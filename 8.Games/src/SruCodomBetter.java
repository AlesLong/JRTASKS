import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.List;

public class SruCodomBetter {
  //  public static void main(String[] args) {
  //      Session session = AnnotationConfigApplicationContext.get(Session.class);
  //  }
}//
//Spring
class Session {
  //  @Autowired
    User user;

    //@Autowired
    ShoppingCart shoppingCart;
}

class ShoppingCart {
   // @Autowired
    List<Product> order;
}
//Hibernate
class User {
   // @Field(id = "userName")
    String name;

    //@Field(id = "password", secured = true)
    String password;
}

class Product {
    //@Field(id = "productName")
    String name;

    //@Field(id = "price")
    BigInteger price;
}

