package querySQL;


public class Query {

    public static final String findRegisteredUser = "SELECT * FROM public.user WHERE username = ? and password = ?";
}
