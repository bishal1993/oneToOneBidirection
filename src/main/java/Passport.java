import javax.persistence.*;

@Entity
@Table(name="passport")
public class Passport {

    @Id
    @Column(name="id_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNumber;


    /**
     * Passport and person has one to one relation and mapped by passport in Person class.
     * On Any Operation in passport will auto matically create action in person table.
     */
    @OneToOne(mappedBy = "passport",cascade = CascadeType.ALL)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        person.setPassport(this);
    }

    public Passport() {
    }

    

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "idNumber=" + idNumber +
                '}';
    }
}
