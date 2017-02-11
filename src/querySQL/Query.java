package querySQL;


public class Query {
    public static final String findRegisteredUser = "SELECT * FROM public.user WHERE username = ? and password = ?";
    public static final String countUsername = "SELECT count(*) FROM public.user WHERE username = ?";
    public static final String addNewUser = "INSERT INTO public.user(name,surname,city,address,birthdate,email,username,password,IBAN,scout) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?) ON CONFLICT(username) DO UPDATE SET name=EXCLUDED.name, surname=EXCLUDED.surname, city=EXCLUDED.city, " +
            "address=EXCLUDED.address, birthdate=EXCLUDED.birthdate, email=EXCLUDED.email, password=EXCLUDED.password, iban=EXCLUDED.iban, scout=EXCLUDED.scout";
    public static final String findStructures = "SELECT * FROM public.structure";
    public static final String findUserByUsername = "SELECT * FROM public.user WHERE username= ?";
    public static final String findLocationByStructure = "SELECT * FROM public.location WHERE structure = ?";
    public static final String removeAvailability = "DELETE FROM public.availability WHERE location = ? AND fromdate = ? AND todate = ?";
    public static final String addAvailability = "INSERT INTO public.availability(location,fromdate,todate) VALUES (?,?,?)";
    public static final String findAvailability = "SELECT * FROM public.availability WHERE location = ?";
    public static final String addNewLocation = "INSERT INTO location(description,numberofrooms,numberofbathrooms,maxguestsnumber,numberofbeds,price," +
            "wifi,smokingRoom,petsallowed,parking,roomservice,conditionedair,views,plasmaTv,structure) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String addNewStrutture = "INSERT INTO structure(name,owner,description,region,city,address,housenumber,cap) VALUES (?,?,?,?,?,?,?,?)";
    public static final String findStructuresByUsername = "SELECT * FROM public.structure WHERE owner = ?";
    public static final String updateUser = "UPDATE public.user SET name = ?, surname = ?, city = ?, address = ?, birthdate = ?, email = ?, " +
            "password = ? , iban = ? WHERE username = ? ";
    public static final String enterNewEmail = "INSERT INTO public.letter(sender, receiver, object, body) VALUES (?,?,?,?)";
    public static final String searchEmailFromUsername = "SELECT email FROM public.user WHERE username =  ?";

    public static final String findSenderNameAndSurname = "SELECT U1.username username1, U2.username username2, object, body FROM public.user U1 JOIN " +
            "public.letter ON U1.email = public.letter.sender JOIN public.user U2 ON U2.email = public.letter.receiver WHERE U1.email = ? ORDER BY id";
    public static final String findReceiverNameAndSurname = "SELECT U1.username username1, U2.username username2, object, body FROM public.user U1 JOIN " +
            "public.letter ON U1.email = public.letter.receiver JOIN public.user U2 ON U2.email = public.letter.sender WHERE U1.email = ? ORDER BY id";
    public static final String findFeedbackByLocation = "SELECT * FROM public.feedback WHERE location = ?";
    public static final String addFeedback = "INSERT INTO feedback(rating,description,username,location) VALUES (?,?,?,?) ON CONFLICT (username,location) DO UPDATE SET rating=EXCLUDED.rating, description=EXCLUDED.description";
    public static final String enterLocationChanges = "INSERT INTO public.location(id,description,numberofrooms,numberofbathrooms,maxguestsnumber,numberofbeds," +
            "price,wifi,smokingroom,petsallowed,parking,roomservice,conditionedair,views,plasmatv) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ON CONFLICT(id) DO " +
            "UPDATE SET description=EXCLUDED.description, numberofrooms=EXCLUDED.numberofrooms, numberofbathrooms=EXCLUDED.numberofbathrooms, " +
            "maxguestsnumber=EXCLUDED.maxguestsnumber, numberofbeds=EXCLUDED.numberofbeds, price=EXCLUDED.price, wifi=EXCLUDED.wifi, " +
            "smokingroom=EXCLUDED.smokingroom, petsallowed=EXCLUDED.petsallowed, parking=EXCLUDED.parking, roomservice=EXCLUDED.roomservice," +
            "conditionedair=EXCLUDED.conditionedair, views=EXCLUDED.views, plasmatv=EXCLUDED.plasmatv";
    public static final String addReservation = "INSERT INTO public.reservation(username,location,fromdate,todate) VALUES (?,?,?,?)";
    public static final String deleteLocation = "DELETE FROM public.reservation WHERE id=?";
    public static final String selectReservation = "SELECT * FROM public.reservation WHERE username=?";
    public static final String checkReservation = "SELECT * FROM public.reservation WHERE username = ? AND location = ?";
}
