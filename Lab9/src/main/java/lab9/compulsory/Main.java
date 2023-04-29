package lab9.compulsory;

import lab9.compulsory.models.Genres;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args){
        // Genres g = new Genres();
        // g.setName("RANDOM STRANGE");

        EntityRepository<Genres> genresEntityRepository = new EntityRepository<>();
        // genresEntityRepository.persist(g);

        Genres g = genresEntityRepository.findById(34);
        System.out.println(g.getName());

        Genres g1 = genresEntityRepository.findByName("RANDOM STRANGE");
        System.out.println(g1.getId());
    }
}
