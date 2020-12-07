package com.syqu.shop;

import com.syqu.shop.product.Product;
import com.syqu.shop.product.ProductService;
import com.syqu.shop.user.User;
import com.syqu.shop.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public StartupData(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void exampleProducts(){


        String NAME1 = "padthai";
        String IMAGE_URL1 = "https://thaipurchasing.com/uploads/news/27102015/padthai/padtai.jpg";
        String DESCRIPTION1 = "Example Description";
        BigDecimal PRICE1 = BigDecimal.valueOf(50);

        String NAME2 = "papaya salad";
        String IMAGE_URL2 = "https://www.matichon.co.th/wp-content/uploads/2016/03/07-3.jpg";
        String DESCRIPTION2 = "Example Description";
        BigDecimal PRICE2 = BigDecimal.valueOf(60);

        String NAME3 = "tomyumkung";
        String IMAGE_URL3 = "https://www.parpaikin.com/wp-content/uploads/2017/12/02-24.jpg";
        String DESCRIPTION3 = "Example Description";
        BigDecimal PRICE3 = BigDecimal.valueOf(120);

        String NAME4 = "bueloy";
        String IMAGE_URL4 = "https://www.xn--12cg3cq6bmlr1hc3fujdh.com/wp-content/uploads/2019/03/%E0%B8%9A%E0%B8%B1%E0%B8%A7%E0%B8%A5%E0%B8%AD%E0%B8%A2%E0%B9%81%E0%B8%81%E0%B9%89%E0%B8%A7.jpg";
        String DESCRIPTION4 = "Example Description";
        BigDecimal PRICE4 = BigDecimal.valueOf(50);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName(NAME1);
        product1.setImageUrl(IMAGE_URL1);
        product1.setDescription(DESCRIPTION1);
        product1.setPrice(PRICE1);

        product2.setName(NAME2);
        product2.setImageUrl(IMAGE_URL2);
        product2.setDescription(DESCRIPTION2);
        product2.setPrice(PRICE2);

        product3.setName(NAME3);
        product3.setImageUrl(IMAGE_URL3);
        product3.setDescription(DESCRIPTION3);
        product3.setPrice(PRICE3);

        product4.setName(NAME4);
        product4.setImageUrl(IMAGE_URL4);
        product4.setDescription(DESCRIPTION4);
        product4.setPrice(PRICE4);



        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
