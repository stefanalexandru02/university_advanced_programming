package lab3.homework;

import java.util.Date;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {
        Company microsoft = new Company("Microsoft");
        Company google = new Company("Google");

        Programmer program1 = new Programmer("Nume programator 1", new Date());
        program1.AddRelationship(microsoft, "Programmer");

        Programmer program2 = new Programmer("Nume programator 2", new Date());
        program2.AddRelationship(google, "Team lead");

        Designer design1 = new Designer("Nume desginer 1", new Date());
        design1.AddRelationship(microsoft, "Lead designer");
        design1.AddRelationship(program2, "Meet on LinkedIn");
        Designer design2 = new Designer("Nume desginer 2", new Date());
        design2.AddRelationship(microsoft, "Designer Intern");

        Person customer1 = new Person("Generic person 1", new Date("15/02/2002"));
        customer1.AddRelationship(microsoft, "Google customer");
        Person customer2 = new Person("Generic person 2", new Date("09/08/2002"));
        customer2.AddRelationship(microsoft, "Microsoft customer");

        Network network = new Network();

        network.addNode(microsoft);
        network.addNode(google);

        network.addNode(program1);
        network.addNode(program2);

        network.addNode(design1);
        network.addNode(design2);

        network.addNode(customer1);
        network.addNode(customer2);

        System.out.println(network);
    }
}
