import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
public static void main(String [] args){

System.out.println("Project started.....");
   SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class).buildSessionFactory();
      Session session = sessionFactory.openSession();

   try{
       Person newPerson = new Person("new firstName","new lastName");


       Passport passport = new Passport( );



      passport.setPerson(newPerson);





session.beginTransaction();

System.out.println("saving...."+passport);
session.save(passport);





    session.getTransaction().commit();
    System.out.println(" ...Done!.....");

   } catch (Exception ex){
    System.out.println("Error...."+ex.getLocalizedMessage());

   } finally {
    sessionFactory.close();
    session.close();
   }



    System.out.println("deleted....");

}

}
