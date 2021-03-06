package main.java.Sailor;

import main.java.Abstract.Abstract;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface PersonCalls{
    default String DisplayName(Human human){
        return "Name: " + GetFirstName(human) + " " + GetLastName(human);
    }

    default String GetFirstName(Human human){
        return human.firstName;
    }

    default String GetLastName(Human human){
        return human.lastName;
    }

    default LocalDate GetBirthdate(Human human){
        return human.birthdate;
    }

    default String DisplayBirthdate(Human human){
        return "Birthdate: " + human.birthdate;
    }

    default String DisplayAge(Human human){
        return "Age: " + GetBirthdate(human);
    }

    default String DisplayNationality(Human human){
        return "Nationality: " + human;
    }

    default String GetGender(Human human){
        return human.gender;
    }

    default String DisplayGender(Human human){
        return "Gender: " + GetGender(human);
    }

}

abstract class Human {
    protected String firstName;
    protected String lastName;
    protected LocalDate birthdate;
    protected String profession;
    protected String gender;
}

public class Person extends Human implements PersonCalls {

    //  private Human humanData;
    private Attributes attrib;
    private Nationality nationality;
    private Contract contract;

    private Person() {

    }

    public static class Builder {

        protected String firstName;
        protected String lastName;
        protected LocalDate Birthdate;
        protected String profession;
        protected String gender;

        //private Human humanData;
        private Attributes attrib;
        private Nationality nationality;
        private Contract contract;

        public Builder(){
            this.gender = SetGender();
            this.Birthdate = SetBirthday();
            this.nationality = new Nationality();
        }

        public Builder(String passedPersonType) {
            this.gender = SetGender();
            this.Birthdate = SetBirthday();
            if (passedPersonType.toLowerCase().contains("long".toLowerCase())) {
                this.attrib = new Attributes();
            } else if (passedPersonType.toLowerCase().contains("vend".toLowerCase())) {
                this.attrib = new Attributes();
            } else {
                //  this.humanData = new Human();
                this.nationality = new Nationality();
                this.attrib = new Attributes();
                this.contract = new Contract(LocalDate.now());
            }

        }

        public Builder(String passedPersonType, String passedFirstName, String passedLastName) {
            this.gender = SetGender();
            this.Birthdate = SetBirthday();
            if (passedPersonType.toLowerCase().contains("long".toLowerCase())) {
                this.attrib = new Attributes();
            } else if (passedPersonType.toLowerCase().contains("vend".toLowerCase())) {
                //     this.humanData = new Human();
                this.attrib = new Attributes();
            } else {
                //this.humanData = new Human(passedFirstName, passedLastName);
                this.nationality = new Nationality();
                this.attrib = new Attributes();
                this.contract = new Contract(LocalDate.now());
            }

        }

        public Builder FirstName(){
            Random random = new Random();
            if(gender == "Male") {
                this.firstName = generatedMaleName[random.nextInt(generatedMaleName.length + 1)];
            } else {
                this.firstName = generatedFemaleName[random.nextInt(generatedFemaleName.length + 1)];
            }
            return this;
        }

        public Builder FirstName(String passedFirstName) {
            this.firstName = passedFirstName;
            return this;
        }

        public Builder LastName() {
            Random random = new Random();
            this.lastName = generatedLastName[random.nextInt(generatedLastName.length + 1)];
            return this;
        }

        public Builder LastName(String passedLastName) {
            this.lastName = passedLastName;
            return this;
        }

        public Builder Nationality(int position) {
            this.nationality = new Nationality(position);
            //   this.nationality.SetNationality(position);
            return this;
        }

  /*      public Builder Attributes(){
            this.attrib = new Attributes();
            return this;
        }*/

        public Builder Attributes() {
            this.attrib.GenerateSkillValue();
            return this;
        }

        public Builder Contract(LocalDate currentDate) {
            this.contract = new Contract(currentDate);
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }
        private Person(Builder builder){
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.birthdate = builder.Birthdate;
            this.gender = builder.gender;
            this.attrib = builder.attrib;
            this.nationality = builder.nationality;
            this.contract = builder.contract;
        }

        static String[] generatedMaleName = {"Liam",	"Noah",	"William",	"James",	"Logan",	"Benjamin",	"Mason",	"Elijah",	"Oliver",	"Jacob",	"Lucas",	"Michael",	"Alexander",	"Ethan",	"Daniel",	"Matthew",	"Aiden",	"Henry",	"Joseph",	"Jackson",	"Samuel",	"Sebastian",	"David",	"Carter",	"Wyatt",	"Jayden",	"John",	"Owen",	"Dylan",	"Luke",	"Gabriel",	"Anthony",	"Isaac",	"Grayson",	"Jack",	"Julian",	"Levi",	"Christopher",	"Joshua",	"Andrew",	"Lincoln",	"Mateo",	"Ryan",	"Jaxon",	"Nathan",	"Aaron",	"Isaiah",	"Thomas",	"Charles",	"Caleb",	"Josiah",	"Christian",	"Hunter",	"Eli",	"Jonathan",	"Connor",	"Landon",	"Adrian",	"Asher",	"Cameron",	"Leo",	"Theodore",	"Jeremiah",	"Hudson",	"Robert",	"Easton",	"Nolan",	"Nicholas",	"Ezra",	"Colton",	"Angel",	"Brayden",	"Jordan",	"Dominic",	"Austin",	"Ian",	"Adam",	"Elias",	"Jaxson",	"Greyson",	"Jose",	"Ezekiel",	"Carson",	"Evan",	"Maverick",	"Bryson",	"Jace",	"Cooper",	"Xavier",	"Parker",	"Roman",	"Jason",	"Santiago",	"Chase",	"Sawyer",	"Gavin",	"Leonardo",	"Kayden",	"Ayden",	"Jameson",	"Kevin",	"Bentley",	"Zachary",	"Everett",	"Axel",	"Tyler",	"Micah",	"Vincent",	"Weston",	"Miles",	"Wesley",	"Nathaniel",	"Harrison",	"Brandon",	"Cole",	"Declan",	"Luis",	"Braxton",	"Damian",	"Silas",	"Tristan",	"Ryder",	"Bennett",	"George",	"Emmett",	"Justin",	"Kai",	"Max",	"Diego",	"Luca",	"Ryker",	"Carlos",	"Maxwell",	"Kingston",	"Ivan",	"Maddox",	"Juan",	"Ashton",	"Jayce",	"Rowan",	"Kaiden",	"Giovanni",	"Eric",	"Jesus",	"Calvin",	"Abel",	"King",	"Camden",	"Amir",	"Blake",	"Alex",	"Brody",	"Malachi",	"Emmanuel",	"Jonah",	"Beau",	"Jude",	"Antonio",	"Alan",	"Elliott",	"Elliot",	"Waylon",	"Xander",	"Timothy",	"Victor",	"Bryce",	"Finn",	"Brantley",	"Edward",	"Abraham",	"Patrick",	"Grant",	"Karter",	"Hayden",	"Richard",	"Miguel",	"Joel",	"Gael",	"Tucker",	"Rhett",	"Avery",	"Steven",	"Graham",	"Kaleb",	"Jasper",	"Jesse",	"Matteo",	"Dean",	"Zayden",	"Preston",	"August",	"Oscar",	"Jeremy",	"Alejandro",	"Marcus",	"Dawson",	"Lorenzo",	"Messiah",	"Zion",	"Maximus",	"River",	"Zane",	"Mark",	"Brooks",	"Nicolas",	"Paxton",	"Judah",	"Emiliano",	"Kaden",	"Bryan",	"Kyle",	"Myles",	"Peter",	"Charlie",	"Kyrie",	"Thiago",	"Brian",	"Kenneth",	"Andres",	"Lukas",	"Aidan",	"Jax",	"Caden",	"Milo",	"Paul",	"Beckett",	"Brady",	"Colin",	"Omar",	"Bradley",	"Javier",	"Knox",	"Jaden",	"Barrett",	"Israel",	"Matias",	"Jorge",	"Zander",	"Derek",	"Josue",	"Cayden",	"Holden",	"Griffin",	"Arthur",	"Leon",	"Felix",	"Remington",	"Jake",	"Killian",	"Clayton",	"Sean",	"Adriel",	"Riley",	"Archer",	"Legend",	"Erick",	"Enzo",	"Corbin",	"Francisco",	"Dallas",	"Emilio",	"Gunner",	"Simon",	"Andre",	"Walter",	"Damien",	"Chance",	"Phoenix",	"Colt",	"Tanner",	"Stephen",	"Kameron",	"Tobias",	"Manuel",	"Amari",	"Emerson",	"Louis",	"Cody",	"Finley",	"Iker",	"Martin",	"Rafael",	"Nash",	"Beckham",	"Cash",	"Karson",	"Rylan",	"Reid",	"Theo",	"Ace",	"Eduardo",	"Spencer",	"Raymond",	"Maximiliano",	"Anderson",	"Ronan",	"Lane",	"Cristian",	"Titus",	"Travis",	"Jett",	"Ricardo",	"Bodhi",	"Gideon",	"Jaiden",	"Fernando",	"Mario",	"Conor",	"Keegan",	"Ali",	"Cesar",	"Ellis",	"Jayceon",	"Walker",	"Cohen",	"Arlo",	"Hector",	"Dante",	"Kyler",	"Garrett",	"Donovan",	"Seth",	"Jeffrey",	"Tyson",	"Jase",	"Desmond",	"Caiden",	"Gage",	"Atlas",	"Major",	"Devin",	"Edwin",	"Angelo",	"Orion",	"Conner",	"Julius",	"Marco",	"Jensen",	"Daxton",	"Peyton",	"Zayn",	"Collin",	"Jaylen",	"Dakota",	"Prince",	"Johnny",	"Kayson",	"Cruz",	"Hendrix",	"Atticus",	"Troy",	"Kane",	"Edgar",	"Sergio",	"Kash",	"Marshall",	"Johnathan",	"Romeo",	"Shane",	"Warren",	"Joaquin",	"Wade",	"Leonel",	"Trevor",	"Dominick",	"Muhammad",	"Erik",	"Odin",	"Quinn",	"Jaxton",	"Dalton",	"Nehemiah",	"Frank",	"Grady",	"Gregory",	"Andy",	"Solomon",	"Malik",	"Rory",	"Clark",	"Reed",	"Harvey",	"Zayne",	"Jay",	"Jared",	"Noel",	"Shawn",	"Fabian",	"Ibrahim",	"Adonis",	"Ismael",	"Pedro",	"Leland",	"Malakai",	"Malcolm",	"Alexis",	"Kason",	"Porter",	"Sullivan",	"Raiden",	"Allen",	"Ari",	"Russell",	"Princeton",	"Winston",	"Kendrick",	"Roberto",	"Lennox",	"Hayes",	"Finnegan",	"Nasir",	"Kade",	"Nico",	"Emanuel",	"Landen",	"Moises",	"Ruben",	"Hugo",	"Abram",	"Adan",	"Khalil",	"Zaiden",	"Augustus",	"Marcos",	"Philip",	"Phillip",	"Cyrus",	"Esteban",	"Braylen",	"Albert",	"Bruce",	"Kamden",	"Lawson",	"Jamison",	"Sterling",	"Damon",	"Gunnar",	"Kyson",	"Luka",	"Franklin",	"Ezequiel",	"Pablo",	"Derrick",	"Zachariah",	"Cade",	"Jonas",	"Dexter",	"Kolton",	"Remy",	"Hank",	"Tate",	"Trenton",	"Kian",	"Drew",	"Mohamed",	"Dax",	"Rocco",	"Bowen",	"Mathias",	"Ronald",	"Francis",	"Matthias",	"Milan",	"Maximilian",	"Royce",	"Skyler",	"Corey",	"Kasen",	"Drake",	"Gerardo",	"Jayson",	"Sage",	"Braylon",	"Benson",	"Moses",	"Alijah",	"Rhys",	"Otto",	"Oakley",	"Armando",	"Jaime",	"Nixon",	"Saul",	"Scott",	"Brycen",	"Ariel",	"Enrique",	"Donald",	"Chandler",	"Asa",	"Eden",	"Davis",	"Keith",	"Frederick",	"Rowen",	"Lawrence",	"Leonidas",	"Aden",	"Julio",	"Darius",	"Johan",	"Deacon",	"Cason",	"Danny",	"Nikolai",	"Taylor",	"Alec",	"Royal",	"Armani",	"Kieran",	"Luciano",	"Omari",	"Rodrigo",	"Arjun",	"Ahmed",	"Brendan",	"Cullen",	"Raul",	"Raphael",	"Ronin",	"Brock",	"Pierce",	"Alonzo",	"Casey",	"Dillon",	"Uriel",	"Dustin",	"Gianni",	"Roland",	"Landyn",	"Kobe",	"Dorian",	"Emmitt",	"Ryland",	"Apollo",	"Aarav",	"Roy",	"Duke",	"Quentin",	"Sam",	"Lewis",	"Tony",	"Uriah",	"Dennis",	"Moshe",	"Isaias",	"Braden",	"Quinton",	"Cannon",	"Ayaan",	"Mathew",	"Kellan",	"Niko",	"Edison",	"Izaiah",	"Jerry",	"Gustavo",	"Jamari",	"Marvin",	"Mauricio",	"Ahmad",	"Mohammad",	"Justice",	"Trey",	"Elian",	"Mohammed",	"Sincere",	"Yusuf",	"Arturo",	"Callen",	"Rayan",	"Keaton",	"Wilder",	"Mekhi",	"Memphis",	"Cayson",	"Conrad",	"Kaison",	"Kyree",	"Soren",	"Colby",	"Bryant",	"Lucian",	"Alfredo",	"Cassius",	"Marcelo",	"Nikolas",	"Brennan",	"Darren",	"Jasiah",	"Jimmy",	"Lionel",	"Reece",	"Ty",	"Chris",	"Forrest",	"Korbin",	"Tatum",	"Jalen",	"Santino",	"Case",	"Leonard",	"Alvin",	"Issac",	"Bo",	"Quincy",	"Mack",	"Samson",	"Rex",	"Alberto",	"Callum",	"Curtis",	"Hezekiah",	"Finnley",	"Briggs",	"Kamari",	"Zeke",	"Raylan",	"Neil",	"Titan",	"Julien",	"Kellen",	"Devon",	"Kylan",	"Roger",	"Axton",	"Carl",	"Douglas",	"Larry",	"Crosby",	"Fletcher",	"Makai",	"Nelson",	"Hamza",	"Lance",	"Alden",	"Gary",	"Wilson",	"Alessandro",	"Ares",	"Kashton",	"Bruno",	"Jakob",	"Stetson",	"Zain",	"Cairo",	"Nathanael",	"Byron",	"Harry",	"Harley",	"Mitchell",	"Maurice",	"Orlando",	"Kingsley",	"Kaysen",	"Sylas",	"Trent",	"Ramon",	"Boston",	"Lucca",	"Noe",	"Jagger",	"Reyansh",	"Vihaan",	"Randy",	"Thaddeus",	"Lennon",	"Kannon",	"Kohen",	"Tristen",	"Valentino",	"Maxton",	"Salvador",	"Abdiel",	"Langston",	"Rohan",	"Kristopher",	"Yosef",	"Rayden",	"Lee",	"Callan",	"Tripp",	"Deandre",	"Joe",	"Morgan",	"Dariel",	"Colten",	"Reese",	"Jedidiah",	"Ricky",	"Bronson",	"Terry",	"Eddie",	"Jefferson",	"Lachlan",	"Layne",	"Clay",	"Madden",	"Jamir",	"Tomas",	"Kareem",	"Stanley",	"Brayan",	"Amos",	"Kase",	"Kristian",	"Clyde",	"Ernesto",	"Tommy",	"Casen",	"Ford",	"Crew",	"Braydon",	"Brecken",	"Hassan",	"Axl",	"Boone",	"Leandro",	"Samir",	"Jaziel",	"Magnus",	"Abdullah",	"Yousef",	"Branson",	"Jadiel",	"Jaxen",	"Layton",	"Franco",	"Ben",	"Grey",	"Kelvin",	"Chaim",	"Demetrius",	"Blaine",	"Ridge",	"Colson",	"Melvin",	"Anakin",	"Aryan",	"Lochlan",	"Jon",	"Canaan",	"Dash",	"Zechariah",	"Alonso",	"Otis",	"Zaire",	"Marcel",	"Brett",	"Stefan",	"Aldo",	"Jeffery",	"Baylor",	"Talon",	"Dominik",	"Flynn",	"Carmelo",	"Dane",	"Jamal",	"Kole",	"Enoch",	"Graysen",	"Kye",	"Vicente",	"Fisher",	"Ray",	"Fox",	"Jamie",	"Rey",	"Zaid",	"Allan",	"Emery",	"Gannon",	"Joziah",	"Rodney",	"Juelz",	"Sonny",	"Terrance",	"Zyaire",	"Augustine",	"Cory",	"Felipe",	"Aron",	"Jacoby",	"Harlan",	"Marc",	"Bobby",	"Joey",	"Anson",	"Huxley",	"Marlon",	"Anders",	"Guillermo",	"Payton",	"Castiel",	"Damari",	"Shepherd",	"Azariah",	"Harold",	"Harper",	"Henrik",	"Houston",	"Kairo",	"Willie",	"Elisha",	"Ameer",	"Emory",	"Skylar",	"Sutton",	"Alfonso",	"Brentley",	"Toby",	"Blaze",	"Eugene",	"Shiloh",	"Wayne",	"Darian",	"Gordon",	"London",	"Bodie",	"Jordy",	"Jermaine",	"Denver",	"Gerald",	"Merrick",	"Musa",	"Vincenzo",	"Kody",	"Yahir",	"Brodie",	"Trace",	"Darwin",	"Tadeo",	"Bentlee",	"Billy",	"Hugh",	"Reginald",	"Vance",	"Westin",	"Cain",	"Arian",	"Dayton",	"Javion",	"Terrence",	"Brysen",	"Jaxxon",	"Thatcher",	"Landry",	"Rene",	"Westley",	"Miller",	"Alvaro",	"Cristiano",	"Eliseo",	"Ephraim",	"Adrien",	"Jerome",	"Khalid",	"Aydin",	"Mayson",	"Alfred",	"Duncan",	"Junior",	"Kendall",	"Zavier",	"Koda",	"Maison",	"Caspian",	"Maxim",	"Kace",	"Zackary",	"Rudy",	"Coleman",	"Keagan",	"Kolten",	"Maximo",	"Dario",	"Davion",	"Kalel",	"Briar",	"Jairo",	"Misael",	"Rogelio",	"Terrell",	"Heath",	"Micheal",	"Wesson",	"Aaden",	"Brixton",	"Draven",	"Xzavier",	"Darrell",	"Keanu",	"Ronnie",	"Konnor",	"Will",	"Dangelo",	"Frankie",	"Kamryn",	"Salvatore",	"Santana",	"Shaun",	"Coen",	"Leighton",	"Mustafa",	"Reuben",	"Ayan",	"Blaise",	"Dimitri",	"Keenan",	"Van",	"Achilles",	"Channing",	"Ishaan",	"Wells",	"Benton",	"Lamar",	"Nova",	"Yahya",	"Dilan",	"Gibson",	"Camdyn",	"Ulises",	"Alexzander",	"Valentin",	"Shepard",	"Alistair",	"Eason",	"Kaiser",	"Leroy",	"Zayd",	"Camilo",	"Markus",	"Foster",	"Davian",	"Dwayne",	"Jabari",	"Judson",	"Koa",	"Yehuda",	"Lyric",	"Tristian",	"Agustin",	"Bridger",	"Vivaan",	"Brayson",	"Emmet",	"Marley",	"Mike",	"Nickolas",	"Kenny",	"Leif",	"Bjorn",	"Ignacio",	"Rocky",	"Chad",	"Gatlin",	"Greysen",	"Kyng",	"Randall",	"Reign",	"Vaughn",	"Jessie",	"Louie",	"Shmuel",	"Zahir",	"Ernest",	"Javon",	"Khari",	"Reagan",	"Avi",	"Ira",	"Ledger",	"Simeon",	"Yadiel",	"Maddux",	"Seamus",	"Jad",	"Jeremias",	"Kylen",	"Rashad",	"Santos",	"Cedric",	"Craig",	"Dominique",	"Gianluca",	"Jovanni",	"Bishop",	"Brenden",	"Anton",	"Camron",	"Giancarlo",	"Lyle",	"Alaric",	"Decker",	"Eliezer",	"Ramiro",	"Yisroel",	"Howard",	"Jaxx"};
        static String[] generatedFemaleName = {"Emma",	"Olivia",	"Ava",	"Isabella",	"Sophia",	"Mia",	"Charlotte",	"Amelia",	"Evelyn",	"Abigail",	"Harper",	"Emily",	"Elizabeth",	"Avery",	"Sofia",	"Ella",	"Madison",	"Scarlett",	"Victoria",	"Aria",	"Grace",	"Chloe",	"Camila",	"Penelope",	"Riley",	"Layla",	"Lillian",	"Nora",	"Zoey",	"Mila",	"Aubrey",	"Hannah",	"Lily",	"Addison",	"Eleanor",	"Natalie",	"Luna",	"Savannah",	"Brooklyn",	"Leah",	"Zoe",	"Stella",	"Hazel",	"Ellie",	"Paisley",	"Audrey",	"Skylar",	"Violet",	"Claire",	"Bella",	"Aurora",	"Lucy",	"Anna",	"Samantha",	"Caroline",	"Genesis",	"Aaliyah",	"Kennedy",	"Kinsley",	"Allison",	"Maya",	"Sarah",	"Madelyn",	"Adeline",	"Alexa",	"Ariana",	"Elena",	"Gabriella",	"Naomi",	"Alice",	"Sadie",	"Hailey",	"Eva",	"Emilia",	"Autumn",	"Quinn",	"Nevaeh",	"Piper",	"Ruby",	"Serenity",	"Willow",	"Everly",	"Cora",	"Kaylee",	"Lydia",	"Aubree",	"Arianna",	"Eliana",	"Peyton",	"Melanie",	"Gianna",	"Isabelle",	"Julia",	"Valentina",	"Nova",	"Clara",	"Vivian",	"Reagan",	"Mackenzie",	"Madeline",	"Brielle",	"Delilah",	"Isla",	"Rylee",	"Katherine",	"Sophie",	"Josephine",	"Ivy",	"Liliana",	"Jade",	"Maria",	"Taylor",	"Hadley",	"Kylie",	"Emery",	"Adalynn",	"Natalia",	"Annabelle",	"Faith",	"Alexandra",	"Ximena",	"Ashley",	"Brianna",	"Raelynn",	"Bailey",	"Mary",	"Athena",	"Andrea",	"Leilani",	"Jasmine",	"Lyla",	"Margaret",	"Alyssa",	"Adalyn",	"Arya",	"Norah",	"Khloe",	"Kayla",	"Eden",	"Eliza",	"Rose",	"Ariel",	"Melody",	"Alexis",	"Isabel",	"Sydney",	"Juliana",	"Lauren",	"Iris",	"Emerson",	"London",	"Morgan",	"Lilly",	"Charlie",	"Aliyah",	"Valeria",	"Arabella",	"Sara",	"Finley",	"Trinity",	"Ryleigh",	"Jordyn",	"Jocelyn",	"Kimberly",	"Esther",	"Molly",	"Valerie",	"Cecilia",	"Anastasia",	"Daisy",	"Reese",	"Laila",	"Mya",	"Amy",	"Teagan",	"Amaya",	"Elise",	"Harmony",	"Paige",	"Adaline",	"Fiona",	"Alaina",	"Nicole",	"Genevieve",	"Lucia",	"Alina",	"Mckenzie",	"Callie",	"Payton",	"Eloise",	"Brooke",	"Londyn",	"Mariah",	"Julianna",	"Rachel",	"Daniela",	"Gracie",	"Catherine",	"Angelina",	"Presley",	"Josie",	"Harley",	"Adelyn",	"Vanessa",	"Makayla",	"Parker",	"Juliette",	"Amara",	"Marley",	"Lila",	"Ana",	"Rowan",	"Alana",	"Michelle",	"Malia",	"Rebecca",	"Brooklynn",	"Brynlee",	"Summer",	"Sloane",	"Leila",	"Sienna",	"Adriana",	"Sawyer",	"Kendall",	"Juliet",	"Destiny",	"Alayna",	"Elliana",	"Diana",	"Hayden",	"Ayla",	"Dakota",	"Angela",	"Noelle",	"Rosalie",	"Joanna",	"Jayla",	"Alivia",	"Lola",	"Emersyn",	"Georgia",	"Selena",	"June",	"Daleyza",	"Tessa",	"Maggie",	"Jessica",	"Remi",	"Delaney",	"Camille",	"Vivienne",	"Hope",	"Mckenna",	"Gemma",	"Olive",	"Alexandria",	"Blakely",	"Izabella",	"Catalina",	"Raegan",	"Journee",	"Gabrielle",	"Lucille",	"Ruth",	"Amiyah",	"Evangeline",	"Blake",	"Thea",	"Amina",	"Giselle",	"Lilah",	"Melissa",	"River",	"Kate",	"Adelaide",	"Charlee",	"Vera",	"Leia",	"Gabriela",	"Zara",	"Jane",	"Journey",	"Elaina",	"Miriam",	"Briella",	"Stephanie",	"Cali",	"Ember",	"Lilliana",	"Aniyah",	"Logan",	"Kamila",	"Brynn",	"Ariella",	"Makenzie",	"Annie",	"Mariana",	"Kali",	"Haven",	"Elsie",	"Nyla",	"Paris",	"Lena",	"Freya",	"Adelynn",	"Lyric",	"Camilla",	"Sage",	"Jennifer",	"Paislee",	"Talia",	"Alessandra",	"Juniper",	"Fatima",	"Raelyn",	"Amira",	"Arielle",	"Phoebe",	"Kinley",	"Ada",	"Nina",	"Ariah",	"Samara",	"Myla",	"Brinley",	"Cassidy",	"Maci",	"Aspen",	"Allie",	"Keira",	"Kaia",	"Makenna",	"Amanda",	"Heaven",	"Joy",	"Lia",	"Madilyn",	"Gracelyn",	"Laura",	"Evelynn",	"Lexi",	"Haley",	"Miranda",	"Kaitlyn",	"Daniella",	"Felicity",	"Jacqueline",	"Evie",	"Angel",	"Danielle",	"Ainsley",	"Dylan",	"Kiara",	"Millie",	"Jordan",	"Maddison",	"Rylie",	"Alicia",	"Maeve",	"Margot",	"Kylee",	"Phoenix",	"Heidi",	"Zuri",	"Alondra",	"Lana",	"Madeleine",	"Gracelynn",	"Kenzie",	"Miracle",	"Shelby",	"Elle",	"Adrianna",	"Bianca",	"Addilyn",	"Kira",	"Veronica",	"Gwendolyn",	"Esmeralda",	"Chelsea",	"Alison",	"Skyler",	"Magnolia",	"Daphne",	"Jenna",	"Everleigh",	"Kyla",	"Braelynn",	"Harlow",	"Annalise",	"Mikayla",	"Dahlia",	"Maliyah",	"Averie",	"Scarlet",	"Kayleigh",	"Luciana",	"Kelsey",	"Nadia",	"Amber",	"Gia",	"Kamryn",	"Yaretzi",	"Carmen",	"Jimena",	"Erin",	"Christina",	"Katie",	"Ryan",	"Viviana",	"Alexia",	"Anaya",	"Serena",	"Katelyn",	"Ophelia",	"Regina",	"Helen",	"Remington",	"Camryn",	"Cadence",	"Royalty",	"Amari",	"Kathryn",	"Skye",	"Emely",	"Jada",	"Ariyah",	"Aylin",	"Saylor",	"Kendra",	"Cheyenne",	"Fernanda",	"Sabrina",	"Francesca",	"Eve",	"Mckinley",	"Frances",	"Sarai",	"Carolina",	"Kennedi",	"Nylah",	"Tatum",	"Alani",	"Lennon",	"Raven",	"Zariah",	"Leslie",	"Winter",	"Abby",	"Mabel",	"Sierra",	"April",	"Willa",	"Carly",	"Jolene",	"Rosemary",	"Aviana",	"Madelynn",	"Selah",	"Renata",	"Lorelei",	"Briana",	"Celeste",	"Wren",	"Charleigh",	"Leighton",	"Annabella",	"Jayleen",	"Braelyn",	"Ashlyn",	"Jazlyn",	"Mira",	"Oakley",	"Malaysia",	"Edith",	"Avianna",	"Maryam",	"Emmalyn",	"Hattie",	"Kensley",	"Macie",	"Bristol",	"Marlee",	"Demi",	"Cataleya",	"Maia",	"Sylvia",	"Itzel",	"Allyson",	"Lilith",	"Melany",	"Kaydence",	"Holly",	"Nayeli",	"Meredith",	"Nia",	"Liana",	"Megan",	"Justice",	"Bethany",	"Alejandra",	"Janelle",	"Elisa",	"Adelina",	"Ashlynn",	"Elianna",	"Aleah",	"Myra",	"Lainey",	"Blair",	"Kassidy",	"Charley",	"Virginia",	"Kara",	"Helena",	"Sasha",	"Julie",	"Michaela",	"Carter",	"Matilda",	"Kehlani",	"Henley",	"Maisie",	"Hallie",	"Jazmin",	"Priscilla",	"Marilyn",	"Cecelia",	"Danna",	"Colette",	"Baylee",	"Elliott",	"Ivanna",	"Cameron",	"Celine",	"Alayah",	"Hanna",	"Imani",	"Angelica",	"Emelia",	"Kalani",	"Alanna",	"Lorelai",	"Macy",	"Karina",	"Addyson",	"Aleena",	"Aisha",	"Johanna",	"Mallory",	"Leona",	"Mariam",	"Kynlee",	"Madilynn",	"Karen",	"Karla",	"Skyla",	"Beatrice",	"Dayana",	"Gloria",	"Milani",	"Savanna",	"Karsyn",	"Rory",	"Giuliana",	"Lauryn",	"Liberty",	"Galilea",	"Aubrie",	"Charli",	"Kyleigh",	"Brylee",	"Jillian",	"Anne",	"Haylee",	"Dallas",	"Azalea",	"Jayda",	"Tiffany",	"Avah",	"Shiloh",	"Bailee",	"Jazmine",	"Esme",	"Coraline",	"Madisyn",	"Elaine",	"Lilian",	"Kyra",	"Kaliyah",	"Kora",	"Octavia",	"Irene",	"Kelly",	"Lacey",	"Laurel",	"Adley",	"Anika",	"Janiyah",	"Dorothy",	"Sutton",	"Julieta",	"Kimber",	"Remy",	"Cassandra",	"Rebekah",	"Collins",	"Elliot",	"Emmy",	"Sloan",	"Hayley",	"Amalia",	"Jemma",	"Jamie",	"Melina",	"Leyla",	"Jaylah",	"Anahi",	"Jaliyah",	"Kailani",	"Harlee",	"Wynter",	"Saige",	"Alessia",	"Monica",	"Anya",	"Antonella",	"Emberly",	"Khaleesi",	"Ivory",	"Greta",	"Maren",	"Alena",	"Emory",	"Alaia",	"Cynthia",	"Addisyn",	"Alia",	"Lylah",	"Angie",	"Ariya",	"Alma",	"Crystal",	"Jayde",	"Aileen",	"Kinslee",	"Siena",	"Zelda",	"Katalina",	"Marie",	"Pearl",	"Reyna",	"Mae",	"Zahra",	"Kailey",	"Jessie",	"Tiana",	"Amirah",	"Madalyn",	"Alaya",	"Lilyana",	"Julissa",	"Armani",	"Lennox",	"Lillie",	"Jolie",	"Laney",	"Roselyn",	"Mara",	"Joelle",	"Rosa",	"Kaylani",	"Bridget",	"Liv",	"Oaklyn",	"Aurelia",	"Clarissa",	"Elyse",	"Marissa",	"Monroe",	"Kori",	"Elsa",	"Rosie",	"Amelie",	"Aitana",	"Aliza",	"Eileen",	"Poppy",	"Emmie",	"Braylee",	"Milana",	"Addilynn",	"Royal",	"Chaya",	"Frida",	"Bonnie",	"Amora",	"Stevie",	"Tatiana",	"Malaya",	"Mina",	"Emerie",	"Reign",	"Zaylee",	"Annika",	"Kenia",	"Linda",	"Kenna",	"Faye",	"Reina",	"Brittany",	"Marina",	"Astrid",	"Kadence",	"Mikaela",	"Jaelyn",	"Briar",	"Kaylie",	"Teresa",	"Bria",	"Hadassah",	"Lilianna",	"Guadalupe",	"Rayna",	"Chanel",	"Lyra",	"Noa",	"Zariyah",	"Laylah",	"Aubrielle",	"Aniya",	"Livia",	"Ellen",	"Meadow",	"Amiya",	"Ellis",	"Elora",	"Milan",	"Hunter",	"Princess",	"Leanna",	"Nathalie",	"Clementine",	"Nola",	"Tenley",	"Simone",	"Lina",	"Marianna",	"Martha",	"Sariah",	"Louisa",	"Noemi",	"Emmeline",	"Kenley",	"Belen",	"Erika",	"Myah",	"Lara",	"Amani",	"Ansley",	"Everlee",	"Maleah",	"Salma",	"Jaelynn",	"Kiera",	"Dulce",	"Nala",	"Natasha",	"Averi",	"Mercy",	"Penny",	"Ariadne",	"Deborah",	"Elisabeth",	"Zaria",	"Hana",	"Kairi",	"Yareli",	"Raina",	"Ryann",	"Lexie",	"Thalia",	"Karter",	"Annabel",	"Christine",	"Estella",	"Keyla",	"Adele",	"Aya",	"Estelle",	"Landry",	"Tori",	"Perla",	"Lailah",	"Miah",	"Rylan",	"Angelique",	"Avalynn",	"Romina",	"Ari",	"Jaycee",	"Jaylene",	"Kai",	"Louise",	"Mavis",	"Scarlette",	"Belle",	"Lea",	"Nalani",	"Rivka",	"Ayleen",	"Calliope",	"Dalary",	"Zaniyah",	"Kaelyn",	"Sky",	"Jewel",	"Joselyn",	"Madalynn",	"Paola",	"Giovanna",	"Isabela",	"Karlee",	"Aubriella",	"Azariah",	"Tinley",	"Dream",	"Claudia",	"Corinne",	"Erica",	"Milena",	"Aliana",	"Kallie",	"Alyson",	"Joyce",	"Tinsley",	"Whitney",	"Emilee",	"Paisleigh",	"Carolyn",	"Jaylee",	"Zoie",	"Frankie",	"Andi",	"Judith",	"Paula",	"Xiomara",	"Aiyana",	"Amia",	"Analia",	"Audrina",	"Hadlee",	"Rayne",	"Amayah",	"Cara",	"Celia",	"Lyanna",	"Opal",	"Amaris",	"Clare",	"Gwen",	"Giana",	"Veda",	"Alisha",	"Davina",	"Rhea",	"Sariyah",	"Noor",	"Danica",	"Kathleen",	"Lillianna",	"Lindsey",	"Maxine",	"Paulina",	"Hailee",	"Harleigh",	"Nancy",	"Jessa",	"Raquel",	"Raylee",	"Zainab",	"Chana",	"Lisa",	"Heavenly",	"Oaklynn",	"Aminah",	"Emmalynn",	"Patricia",	"India",	"Janessa",	"Paloma",	"Ramona",	"Sandra",	"Abril",	"Emmaline",	"Itzayana",	"Kassandra",	"Vienna",	"Marleigh",	"Kailyn",	"Novalee",	"Rosalyn",	"Hadleigh",	"Luella",	"Taliyah",	"Avalyn",	"Barbara",	"Iliana",	"Jana",	"Meilani",	"Aadhya",	"Alannah",	"Blaire",	"Brenda",	"Casey",	"Selene",	"Lizbeth",	"Adrienne",	"Annalee",	"Malani",	"Aliya",	"Miley",	"Nataly",	"Bexley",	"Joslyn",	"Maliah",	"Zion",	"Breanna",	"Melania",	"Estrella",	"Ingrid",	"Jayden",	"Kaya",	"Kaylin",	"Harmoni",	"Arely",	"Jazlynn",	"Kiana",	"Dana",	"Mylah",	"Oaklee",	"Ailani",	"Kailee",	"Legacy",	"Marjorie",	"Paityn",	"Courtney",	"Ellianna",	"Jurnee",	"Karlie",	"Evalyn",	"Holland",	"Kenya",	"Magdalena",	"Carla",	"Halle",	"Aryanna",	"Kaiya",	"Kimora",	"Naya",	"Saoirse",	"Susan",	"Desiree",	"Ensley",	"Renee",	"Esperanza",	"Treasure",	"Caylee",	"Ellison",	"Kristina",	"Adilynn",	"Anabelle",	"Egypt",	"Spencer",	"Tegan",	"Aranza",	"Vada",	"Emerald",	"Florence",	"Marlowe",	"Micah",	"Sonia",	"Sunny",	"Tara",	"Riya",	"Yara",	"Alisa",	"Nathalia",	"Yamileth",	"Saanvi",	"Samira",	"Sylvie",	"Brenna",	"Carlee",	"Jenny",	"Miya",	"Monserrat",	"Zendaya",	"Alora"};
        static String[] generatedLastName = {"Smith",	"Johnson",	"Williams",	"Jones",	"Brown",	"Davis",	"Miller",	"Wilson",	"Moore",	"Taylor",	"Anderson",	"Thomas",	"Jackson",	"White",	"Harris",	"Martin",	"Thompson",	"Garcia",	"Martinez",	"Robinson",	"Clark",	"Rodriguez",	"Lewis",	"Lee",	"Walker",	"Hall",	"Allen",	"Young",	"Hernandez",	"King",	"Wright",	"Lopez",	"Hill",	"Scott",	"Green",	"Adams",	"Baker",	"Gonzalez",	"Nelson",	"Carter",	"Mitchell",	"Perez",	"Roberts",	"Turner",	"Phillips",	"Campbell",	"Parker",	"Evans",	"Edwards",	"Collins",	"Stewart",	"Sanchez",	"Morris",	"Rogers",	"Reed",	"Cook",	"Morgan",	"Bell",	"Murphy",	"Bailey",	"Rivera",	"Cooper",	"Richardson",	"Cox",	"Howard",	"Ward",	"Torres",	"Peterson",	"Gray",	"Ramirez",	"James",	"Watson",	"Brooks",	"Kelly",	"Sanders",	"Price",	"Bennett",	"Wood",	"Barnes",	"Ross",	"Henderson",	"Coleman",	"Jenkins",	"Perry",	"Powell",	"Long",	"Patterson",	"Hughes",	"Flores",	"Washington",	"Butler",	"Simmons",	"Foster",	"Gonzales",	"Bryant",	"Alexander",	"Russell",	"Griffin",	"Diaz",	"Hayes",	"Myers",	"Ford",	"Hamilton",	"Graham",	"Sullivan",	"Wallace",	"Woods",	"Cole",	"West",	"Jordan",	"Owens",	"Reynolds",	"Fisher",	"Ellis",	"Harrison",	"Gibson",	"Mcdonald",	"Cruz",	"Marshall",	"Ortiz",	"Gomez",	"Murray",	"Freeman",	"Wells",	"Webb",	"Simpson",	"Stevens",	"Tucker",	"Porter",	"Hunter",	"Hicks",	"Crawford",	"Henry",	"Boyd",	"Mason",	"Morales",	"Kennedy",	"Warren",	"Dixon",	"Ramos",	"Reyes",	"Burns",	"Gordon",	"Shaw",	"Holmes",	"Rice",	"Robertson",	"Hunt",	"Black",	"Daniels",	"Palmer",	"Mills",	"Nichols",	"Grant",	"Knight",	"Ferguson",	"Rose",	"Stone",	"Hawkins",	"Dunn",	"Perkins",	"Hudson",	"Spencer",	"Gardner",	"Stephens",	"Payne",	"Pierce",	"Berry",	"Matthews",	"Arnold",	"Wagner",	"Willis",	"Ray",	"Watkins",	"Olson",	"Carroll",	"Duncan",	"Snyder",	"Hart",	"Cunningham",	"Bradley",	"Lane",	"Andrews",	"Ruiz",	"Harper",	"Fox",	"Riley",	"Armstrong",	"Carpenter",	"Weaver",	"Greene",	"Lawrence",	"Elliott",	"Chavez",	"Sims",	"Austin",	"Peters",	"Kelley",	"Franklin",	"Lawson",	"Fields",	"Gutierrez",	"Ryan",	"Schmidt",	"Carr",	"Vasquez",	"Castillo",	"Wheeler",	"Chapman",	"Oliver",	"Montgomery",	"Richards",	"Williamson",	"Johnston",	"Banks",	"Meyer",	"Bishop",	"Mccoy",	"Howell",	"Alvarez",	"Morrison",	"Hansen",	"Fernandez",	"Garza",	"Harvey",	"Little",	"Burton",	"Stanley",	"Nguyen",	"George",	"Jacobs",	"Reid",	"Kim",	"Fuller",	"Lynch",	"Dean",	"Gilbert",	"Garrett",	"Romero",	"Welch",	"Larson",	"Frazier",	"Burke",	"Hanson",	"Day",	"Mendoza",	"Moreno",	"Bowman",	"Medina",	"Fowler",	"Brewer",	"Hoffman",	"Carlson",	"Silva",	"Pearson",	"Holland",	"Douglas",	"Fleming",	"Jensen",	"Vargas",	"Byrd",	"Davidson",	"Hopkins",	"May",	"Terry",	"Herrera",	"Wade",	"Soto",	"Walters",	"Curtis",	"Neal",	"Caldwell",	"Lowe",	"Jennings",	"Barnett",	"Graves",	"Jimenez",	"Horton",	"Shelton",	"Barrett",	"Obrien",	"Castro",	"Sutton",	"Gregory",	"Mckinney",	"Lucas",	"Miles",	"Craig",	"Rodriquez",	"Chambers",	"Holt",	"Lambert",	"Fletcher",	"Watts",	"Bates",	"Hale",	"Rhodes",	"Pena",	"Beck",	"Newman",	"Haynes",	"Mcdaniel",	"Mendez",	"Bush",	"Vaughn",	"Parks",	"Dawson",	"Santiago",	"Norris",	"Hardy",	"Love",	"Steele",	"Curry",	"Powers",	"Schultz",	"Barker",	"Guzman",	"Page",	"Munoz",	"Ball",	"Keller",	"Chandler",	"Weber",	"Leonard",	"Walsh",	"Lyons",	"Ramsey",	"Wolfe",	"Schneider",	"Mullins",	"Benson",	"Sharp",	"Bowen",	"Daniel",	"Barber",	"Cummings",	"Hines",	"Baldwin",	"Griffith",	"Valdez",	"Hubbard",	"Salazar",	"Reeves",	"Warner",	"Stevenson",	"Burgess",	"Santos",	"Tate",	"Cross",	"Garner",	"Mann",	"Mack",	"Moss",	"Thornton",	"Dennis",	"Mcgee",	"Farmer",	"Delgado",	"Aguilar",	"Vega",	"Glover",	"Manning",	"Cohen",	"Harmon",	"Rodgers",	"Robbins",	"Newton",	"Todd",	"Blair",	"Higgins",	"Ingram",	"Reese",	"Cannon",	"Strickland",	"Townsend",	"Potter",	"Goodwin",	"Walton",	"Rowe",	"Hampton",	"Ortega",	"Patton",	"Swanson",	"Joseph",	"Francis",	"Goodman",	"Maldonado",	"Yates",	"Becker",	"Erickson",	"Hodges",	"Rios",	"Conner",	"Adkins",	"Webster",	"Norman",	"Malone",	"Hammond",	"Flowers",	"Cobb",	"Moody",	"Quinn",	"Blake",	"Maxwell",	"Pope",	"Floyd",	"Osborne",	"Paul",	"Mccarthy",	"Guerrero",	"Lindsey",	"Estrada",	"Sandoval",	"Gibbs",	"Tyler",	"Gross",	"Fitzgerald",	"Stokes",	"Doyle",	"Sherman",	"Saunders",	"Wise",	"Colon",	"Gill",	"Alvarado",	"Greer",	"Padilla",	"Simon",	"Waters",	"Nunez",	"Ballard",	"Schwartz",	"Mcbride",	"Houston",	"Christensen",	"Klein",	"Pratt",	"Briggs",	"Parsons",	"Mclaughlin",	"Zimmerman",	"French",	"Buchanan",	"Moran",	"Copeland",	"Roy",	"Pittman",	"Brady",	"Mccormick",	"Holloway",	"Brock",	"Poole",	"Frank",	"Logan",	"Owen",	"Bass",	"Marsh",	"Drake",	"Wong",	"Jefferson",	"Park",	"Morton",	"Abbott",	"Sparks",	"Patrick",	"Norton",	"Huff",	"Clayton",	"Massey",	"Lloyd",	"Figueroa",	"Carson",	"Bowers",	"Roberson",	"Barton",	"Tran",	"Lamb",	"Harrington",	"Casey",	"Boone",	"Cortez",	"Clarke",	"Mathis",	"Singleton",	"Wilkins",	"Cain",	"Bryan",	"Underwood",	"Hogan",	"Mckenzie",	"Collier",	"Luna",	"Phelps",	"Mcguire",	"Allison",	"Bridges",	"Wilkerson",	"Nash",	"Summers",	"Atkins",	"Wilcox",	"Pitts",	"Conley",	"Marquez",	"Burnett",	"Richard",	"Cochran",	"Chase",	"Davenport",	"Hood",	"Gates",	"Clay",	"Ayala",	"Sawyer",	"Roman",	"Vazquez",	"Dickerson",	"Hodge",	"Acosta",	"Flynn",	"Espinoza",	"Nicholson",	"Monroe",	"Wolf",	"Morrow",	"Kirk",	"Randall",	"Anthony",	"Whitaker",	"Oconnor",	"Skinner",	"Ware",	"Molina",	"Kirby",	"Huffman",	"Bradford",	"Charles",	"Gilmore",	"Dominguez",	"Oneal",	"Bruce",	"Lang",	"Combs",	"Kramer",	"Heath",	"Hancock",	"Gallagher",	"Gaines",	"Shaffer",	"Short",	"Wiggins",	"Mathews",	"Mcclain",	"Fischer",	"Wall",	"Small",	"Melton",	"Hensley",	"Bond",	"Dyer",	"Cameron",	"Grimes",	"Contreras",	"Christian",	"Wyatt",	"Baxter",	"Snow",	"Mosley",	"Shepherd",	"Larsen",	"Hoover",	"Beasley",	"Glenn",	"Petersen",	"Whitehead",	"Meyers",	"Keith",	"Garrison",	"Vincent",	"Shields",	"Horn",	"Savage",	"Olsen",	"Schroeder",	"Hartman",	"Woodard",	"Mueller",	"Kemp",	"Deleon",	"Booth",	"Patel",	"Calhoun",	"Wiley",	"Eaton",	"Cline",	"Navarro",	"Harrell",	"Lester",	"Humphrey",	"Parrish",	"Duran",	"Hutchinson",	"Hess",	"Dorsey",	"Bullock",	"Robles",	"Beard",	"Dalton",	"Avila",	"Vance",	"Rich",	"Blackwell",	"York",	"Johns",	"Blankenship",	"Trevino",	"Salinas",	"Campos",	"Pruitt",	"Moses",	"Callahan",	"Golden",	"Montoya",	"Hardin",	"Guerra",	"Mcdowell",	"Carey",	"Stafford",	"Gallegos",	"Henson",	"Wilkinson",	"Booker",	"Merritt",	"Miranda",	"Atkinson",	"Orr",	"Decker",	"Hobbs",	"Preston",	"Tanner",	"Knox",	"Pacheco",	"Stephenson",	"Glass",	"Rojas",	"Serrano",	"Marks",	"Hickman",	"English",	"Sweeney",	"Strong",	"Prince",	"Mcclure",	"Conway",	"Walter",	"Roth",	"Maynard",	"Farrell",	"Lowery",	"Hurst",	"Nixon",	"Weiss",	"Trujillo",	"Ellison",	"Sloan",	"Juarez",	"Winters",	"Mclean",	"Randolph",	"Leon",	"Boyer",	"Villarreal",	"Mccall",	"Gentry",	"Carrillo",	"Kent",	"Ayers",	"Lara",	"Shannon",	"Sexton",	"Pace",	"Hull",	"Leblanc",	"Browning",	"Velasquez",	"Leach",	"Chang",	"House",	"Sellers",	"Herring",	"Noble",	"Foley",	"Bartlett",	"Mercado",	"Landry",	"Durham",	"Walls",	"Barr",	"Mckee",	"Bauer",	"Rivers",	"Everett",	"Bradshaw",	"Pugh",	"Velez",	"Rush",	"Estes",	"Dodson",	"Morse",	"Sheppard",	"Weeks",	"Camacho",	"Bean",	"Barron",	"Livingston",	"Middleton",	"Spears",	"Branch",	"Blevins",	"Chen",	"Kerr",	"Mcconnell",	"Hatfield",	"Harding",	"Ashley",	"Solis",	"Herman",	"Frost",	"Giles",	"Blackburn",	"William",	"Pennington",	"Woodward",	"Finley",	"Mcintosh",	"Koch",	"Best",	"Solomon",	"Mccullough",	"Dudley",	"Nolan",	"Blanchard",	"Rivas",	"Brennan",	"Mejia",	"Kane",	"Benton",	"Joyce",	"Buckley",	"Haley",	"Valentine",	"Maddox",	"Russo",	"Mcknight",	"Buck",	"Moon",	"Mcmillan",	"Crosby",	"Berg",	"Dotson",	"Mays",	"Roach",	"Church",	"Chan",	"Richmond",	"Meadows",	"Faulkner",	"Oneill",	"Knapp",	"Kline",	"Barry",	"Ochoa",	"Jacobson",	"Gay",	"Avery",	"Hendricks",	"Horne",	"Shepard",	"Hebert",	"Cherry",	"Cardenas",	"Mcintyre",	"Whitney",	"Waller",	"Holman",	"Donaldson",	"Cantu",	"Terrell",	"Morin",	"Gillespie",	"Fuentes",	"Tillman",	"Sanford",	"Bentley",	"Peck",	"Key",	"Salas",	"Rollins",	"Gamble",	"Dickson",	"Battle",	"Santana",	"Cabrera",	"Cervantes",	"Howe",	"Hinton",	"Hurley",	"Spence",	"Zamora",	"Yang",	"Mcneil",	"Suarez",	"Case",	"Petty",	"Gould",	"Mcfarland",	"Sampson",	"Carver",	"Bray",	"Rosario",	"Macdonald",	"Stout",	"Hester",	"Melendez",	"Dillon",	"Farley",	"Hopper",	"Galloway",	"Potts",	"Bernard",	"Joyner",	"Stein",	"Aguirre",	"Osborn",	"Mercer",	"Bender",	"Franco",	"Rowland",	"Sykes",	"Benjamin",	"Travis",	"Pickett",	"Crane",	"Sears",	"Mayo",	"Dunlap",	"Hayden",	"Wilder",	"Mckay",	"Coffey",	"Mccarty",	"Ewing",	"Cooley",	"Vaughan",	"Bonner",	"Cotton",	"Holder",	"Stark",	"Ferrell",	"Cantrell",	"Fulton",	"Lynn",	"Lott",	"Calderon",	"Rosa",	"Pollard",	"Hooper",	"Burch",	"Mullen",	"Fry",	"Riddle",	"Levy",	"David",	"Duke",	"Odonnell",	"Guy",	"Michael",	"Britt",	"Frederick",	"Daugherty",	"Berger",	"Dillard",	"Alston",	"Jarvis",	"Frye",	"Riggs",	"Chaney",	"Odom",	"Duffy",	"Fitzpatrick",	"Valenzuela",	"Merrill",	"Mayer",	"Alford",	"Mcpherson",	"Acevedo",	"Donovan",	"Barrera",	"Albert",	"Cote",	"Reilly",	"Compton",	"Raymond",	"Mooney",	"Mcgowan",	"Craft",	"Cleveland",	"Clemons",	"Wynn",	"Nielsen",	"Baird",	"Stanton",	"Snider",	"Rosales",	"Bright",	"Witt",	"Stuart",	"Hays",	"Holden",	"Rutledge",	"Kinney",	"Clements",	"Castaneda",	"Slater",	"Hahn",	"Emerson",	"Conrad",	"Burks",	"Delaney",	"Pate",	"Lancaster",	"Sweet",	"Justice",	"Tyson",	"Sharpe",	"Whitfield",	"Talley",	"Macias",	"Irwin",	"Burris",	"Ratliff",	"Mccray",	"Madden",	"Kaufman",	"Beach",	"Goff",	"Cash",	"Bolton",	"Mcfadden",	"Levine",	"Good",	"Byers",	"Kirkland",	"Kidd",	"Workman",	"Carney",	"Dale",	"Mcleod",	"Holcomb",	"England",	"Finch",	"Head",	"Burt",	"Hendrix",	"Sosa",	"Haney",	"Franks",	"Sargent",	"Nieves",	"Downs",	"Rasmussen",	"Bird",	"Hewitt",	"Lindsay",	"Le",	"Foreman",	"Valencia",	"Oneil",	"Delacruz",	"Vinson",	"Dejesus",	"Hyde",	"Forbes",	"Gilliam",	"Guthrie",	"Wooten",	"Huber",	"Barlow",	"Boyle",	"Mcmahon",	"Buckner",	"Rocha",	"Puckett",	"Langley",	"Knowles",	"Cooke",	"Velazquez",	"Whitley",	"Noel",	"Vang"};


        public String GetNationality(){
            return "Nationality: " + this.nationality.nationality;
        }

        public String GetContractStart(){
            return  "Contract Start: " + this.contract.startDate;
        }

        public String GetContractEnd(){
            return "Contract End: " + this.contract.completionDate;
        }

        public void SetFirstName(String passedFirstName){
            this.firstName = passedFirstName;
        }

        public static String SetGender(){
            Random random = new Random();
            if(random.nextInt(100 + 1) > 60){
                return "Male";
            } else {
                return "Female";
            }
        }

        public void SetFirstName(){
            Random random = new Random();
            if(this.gender == "Male") {
                this.firstName = generatedMaleName[random.nextInt(generatedMaleName.length + 1)];
            } else {
                this.firstName = generatedFemaleName[random.nextInt(generatedFemaleName.length + 1)];
            }
        }

        public void SetLastName(String passedLastName){
            this.lastName = passedLastName;
        }

    public String GetSkills(){
        StringBuilder skillDisplay = new StringBuilder();
        for(int i = 0; i < this.attrib.titles.size(); i++){
            skillDisplay.append("\n");
            skillDisplay.append(this.attrib.titles.get(i));
            skillDisplay.append(": ");
            skillDisplay.append(this.attrib.skills.get(i));
        }
        return skillDisplay.toString();
    }

        public static LocalDate SetBirthday(){
            Random random = new Random();
            int minDay = (int) LocalDate.of(LocalDate.now().getYear() - 65, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()).toEpochDay();
            int maxDay = (int) LocalDate.of(LocalDate.now().getYear() - 18, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()).toEpochDay();
            long randomDay = minDay + random.nextInt(maxDay - minDay);

            LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

            return randomBirthDate;
        }

}

class Attributes{

    protected ArrayList titles = new ArrayList();
    protected ArrayList skills = new ArrayList();

    public Attributes(){
        InitializeTitle();
        InitializeSkill();
    }

    public Attributes(String[] skillList){
        InitializeTitle(skillList);
        InitializeSkill();
    }

    public void SetSkillValue(int skillPosition, int passedValue){
        skills.set(skillPosition, passedValue);
    }

    private void InitializeTitle(String[] skillList){
        for(int i = 0; i < skillList.length; i++){
            titles.add(skillList);
        }
    }

    private void GenerateSkillValue(int skillPosition){
        //  double[] pointValues = new double[10];
        int pointValues = 0;
        Random randomValue = new Random();
        for(int i = 0; i < 10; i++){
            pointValues += randomValue.nextInt(10);
        }
        pointValues = pointValues / 20;
        String[] stringValue = ("" + pointValues).split(".");
        skills.set(skillPosition, Integer.parseInt(stringValue[0]));
    }

    public void GenerateSkillValue() {
        //  double[] pointValues = new double[10];
        int pointValues = 0;
        Random randomValue = new Random();
        for (int a = 0; a < skills.size(); a++) {
            for (int i = 0; i < 10; i++) {
                pointValues += randomValue.nextInt(10);
            }
            pointValues = pointValues / 20;
            skills.set(a, pointValues);
        }
    }

    private void InitializeTitle(){
        titles.add("Loading");
        titles.add("Navigation");
        titles.add("Engineering");
        titles.add("Cooking");
        titles.add("Communications");
        titles.add("Defense");
        titles.add("Medical");
    }

    private void InitializeSkill(){
        for(int i = 0; i < titles.size(); i++){
            skills.add(0);
        }
    }

}

class Nationality{

    protected String nationality;

    public Nationality(){
        SetNationality();
    }

    public Nationality(String passedNationality){
        SetNationality(passedNationality);
    }

    public Nationality(int passedNationality){
        SetNationality(passedNationality);
    }

    public void SetNationality(){
        this.nationality = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\NationList.properties");
    }

    public void SetNationality(int position){
        this.nationality = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\NationList.properties", position);
    }

    public void SetNationality(String passedNation){
        this.nationality = passedNation;
    }

}

class Contract{
    protected LocalDate startDate;
    protected LocalDate completionDate;

    public Contract() {
        SetCompletionDate();
    }

    public Contract(LocalDate passedDate) {
        SetStartDate(passedDate);
        SetCompletionDate(passedDate);
    }

    public void SetCompletionDate(){
        Random random = new Random();
        int minContractLength = 15;
        int maxContractLength = 1825;
        long randomDay = minContractLength + random.nextInt(maxContractLength - minContractLength);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

        this.completionDate = randomBirthDate;
    }

    public void SetCompletionDate(LocalDate passedDate){
        Random random = new Random();
        int minContractLength = 15;
        int maxContractLength = 1825;
        long randomDay = minContractLength + random.nextInt(maxContractLength - minContractLength);

        LocalDate localDate = passedDate;

        LocalDate randomDate = localDate.plusDays(randomDay);

        this.completionDate = randomDate;
    }

    public void SetStartDate(LocalDate passedCurrentDate){
        this.startDate = passedCurrentDate;
    }

}

/*class Salary{

    double[] salaryValues = {158.33,	1041.66,	1258.33,	1083.33,	4158.33,	566.66,	1016.66,	2191.66,	1725,	758.33,	2108.33,	4158.33,	4100,	1450,	2091.66,	4316.66,	350,	1458.33,	1550,	3858.33,	691.66,	183.33,	7141.66,	725,	625,	950,	1508.33,	1291.66,	3525,	6391.66,	1800,	158.33,	66.66,	333.33,	283.33,	4008.33,	575,	3650,	58.33,	200,	2050,	1383.33,	1208.33,	133.33,	66.66,	558.33,	1025,	1433.33,	325,	2008.33,	991.66,	1250,	3050,	2933.33,	4133.33,	300,	1000,	1416.66,	933.33,	1083.33,	741.66,	2908.33,	116.66,	2625,	825,	175,	3408.33,	8016.66,	3333.33,	825,	3666.66,	3633.33,	1416.66,	1608.33,	141.66,	883.33,	4183.33,	383.33,	5141.66,	2316.66,	3133.33,	1225,	2541.66,	683.33,	4375,	166.66,	150,	691.66,	150,	458.33,	5083.33,	2408.33,	4341.66,	600,	1033.33,	1666.66,	1416.66,	6050,	7050,	3016.66,	3175,	766.66,	3558.33,	4125,	1041.66,	2175,	291.66,	158.33,	141.66,	3283.33,	866.66,	5808.33,	308.33,	616.66,	2275,	1625,	325,	75,	816.66,	11591.66,	2658.33,	9091.66,	9533.33,	133.33,	100,	2408.33,	1600,	183.33,	3541.66,	283.33,	375,	1800,	1625,	283.33,	475,	9641.66,	1050,	1450,	708.33,	716.66,	108.33,	525,	958.33,	1016.66,	4466.66,	2591.66,	3241.66,	483.33,	100,	491.66,	483.33,	1266.66,	1108.33,	5883.33,	3791.66,	450,	1391.66,	358.33,	2025,	316.66,	816.66,	1108.33,	683.33,	2441.66,	2525,	3108.33,	10408.33,	2000,	2325,	175,	650,	2233.33,	1125,	1608.33,	2908.33,	966.66,	475,	4958.33,	266.66,	4608.33,	225,	1266.66,	2408.33,	150,	7541.66,	5566.66,	2741.66,	2841.66,	175,	16.66,	1116.66,	125,	3191.66,	1083.33,	383.33,	1158.33,	4275,	241.66,	4150,	258.33,	275,	1483.33,	416.66,	133.33,	83.33,	466.66,	2600,	1000,	2208.33,	1558.33,	2425,	316.66,	3008.33,	200,	725,	5683.33,	3633.33,	4958.33,	1866.66,	583.33,	233.33,	1033.33,	575,	316.66,	208.33,	191.66,	333.33,	191.66,	650,	225,	5116.66};

}

class Abstract{

    public static int GetListCount(String passedFilePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(passedFilePath));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            return lines;
        }catch(FileNotFoundException fnfe){
            System.err.println(fnfe);
        }catch(IOException ioe){
            System.err.println(ioe);
        }
        return -1;
    }

    public static String GetItemFromList(String passedFilePath, int passedValue){
        try {
            Path pathToMyTextFile = Paths.get(passedFilePath);
            List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);

            String finalString = linesInFile.get(passedValue).replace("\"", "");

            return finalString;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return "-1";
    }

    public static String GetItemFromList(String passedFilePath){
        try {
            Path pathToMyTextFile = Paths.get(passedFilePath);
            List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
            Random randomUtil = new Random();

            int max = linesInFile.size() - 1;
            int min = 0;

            int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

            String finalString = linesInFile.get(randomIndexForWord).replace("\"", "");

            return finalString;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return "-1";
    }

}*/