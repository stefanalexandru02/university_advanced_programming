package homework;

import compulsory.Catalog;
import homework.exceptions.FileAccessException;
import homework.exceptions.GenericCustomException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.awt.*;
import java.io.*;

/**
 * @author Virna Stefan Alexandru
 */
public class ReportCommand implements Command{
    @Override
    public void executeOperation(Catalog catalog) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template t = velocityEngine.getTemplate("index.vm");

        VelocityContext context = new VelocityContext();
        context.put("documents", catalog.getDocumentsList());

        StringWriter writer = new StringWriter();
        t.merge( context, writer );

        try{
            Writer fileWriter = new FileWriter("report.html", false);
            fileWriter.write(writer.toString());
            fileWriter.flush();

            Desktop desktop = Desktop.getDesktop();
            File myFile = new File("report.html");
            desktop.open(myFile);
        }
        catch (IOException ex) {
            throw new FileAccessException(ex.toString());
        }
        catch (Exception ex) {
            throw new GenericCustomException(ex.toString());
        }
    }
}
