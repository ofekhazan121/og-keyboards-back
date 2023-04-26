package com.example.OGKeys.component;

import com.example.OGKeys.model.AuthUser;
import com.example.OGKeys.model.Product;
import com.example.OGKeys.model.Role;
import com.example.OGKeys.model.Spec;
import com.example.OGKeys.repository.OrderProductRepository;
import com.example.OGKeys.repository.ProductRepository;
import com.example.OGKeys.repository.SpecRepository;
import com.example.OGKeys.repository.UserRepository;
import com.example.OGKeys.service.ProductService;
import com.example.OGKeys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class RunAfterStartUp {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SpecRepository specRepository;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void runAfter( ) {
        Optional<AuthUser> testUser = userRepository.findByUserName("admin1");
        if (testUser.isEmpty()) {
            AuthUser admin1 = new AuthUser("admin1","admin1@gmail.com","admin1",Role.ADMIN,"admin","admin");
            userService.addUser(admin1);

            AuthUser worker1 = new AuthUser("worker1","worker1@gmail.com","worker1",Role.WORKER,"worker","worker");
            userService.addUser(worker1);

            AuthUser user1 = new AuthUser("user1","user1@gmail.com","user1",Role.CLIENT,"user","user");
            userService.addUser(user1);

            Product product1 = new Product("Hippo PBT Keycaps", 63.99F,"PolyCaps","Hippo","Keycaps","PBT Keycaps", "Designed by HipyoTech, this keycap set features thick PBT and dye-sub legends on a light purple and pink palette with lots of novelties.");
            Spec spec1 = new Spec("Cherry", "PBT","Double-shot","181 Total","Supports all conventional layouts: 60%, 65%, and full size + ISO");
            productService.saveProduct(product1,spec1);

            Product product2 = new Product("Whale PBT Keycaps",63.99F, "PolyCaps","Whale","Keycaps","PBT Keycaps","Made of thick PBT and double-shot legends, these whale-themed keycaps will be a colorful addition to your keyboard setup.");
            Spec spec2 = new Spec("Cherry", "PBT","Double-shot","147 total","Supports all conventional layouts: 60%, 65%, and full size + ISO");
            productService.saveProduct(product2,spec2);

            Product product3 = new Product("Seal V2", 63.99F,"PolyCaps","Seal V2","Keycaps","PBT Keycaps","It's true what they say about gray-- it matches with everything! Add this double-shot PBT keycap set to your setup to tie it all together.");
            Spec spec3 = new Spec("Cherry", "PBT","Double-shot","147 total","Supports all conventional layouts: 60%, 65%, and full size + ISO");
            productService.saveProduct(product3,spec3);


            Product product4 = new Product("Code PBT Keycaps", 63.99F,"PolyCaps","Code","Keycaps","PBT Keycaps","Vibrant design inspired by the bright green of phosphor dots in terminals during the early days of personal computing.");
            Spec spec4 = new Spec("Cherry", "PBT","Double-shot","147 total","Supports all conventional layouts: 60%, 65%, and full size + ISO");
            productService.saveProduct(product4,spec4);

            Product product5 = new Product("TG67 V2 Mechanical Keyboard",280.00F,"Kinetic Labs","TG67 V2", "Keyboard", "Kit","The TG67 is a 67% gasket mounted hot-swappable mechanical keyboard kit with arrow keys and VIA compatibility. Kit does not include stabilizers, switches, or keycaps.");
            Spec spec5 = new Spec("67%","6063 Aluminum (body), brass weight","Includes Polycarbonate plate","Bright RGB","screw in","5-Pin","Type-C");
            productService.saveProduct(product5,spec5);

            Product product6 = new Product("WS Morandi Linear Switches",30.10F,"Wuque Studio","Morandi","Switch","Linear","The Morandi linear switches by Wuque Studio feature factory lube and per-switch removable light diffusers.");
            Spec spec6 = new Spec("UPE","POM","Haimu","5-Pin","Linear","3.50","60g");
            productService.saveProduct(product6,spec6);

            Product product7 = new Product("Magnifying Glasses",14.99F,"Kinetic Labs","Magnifying Glasses","Accessories","Glasses","Comes with 5 interchangeable lenses, ranging from 1.0x to 3.5x. Requires 3 AAA batteries (included) for the light. Perfect addition to lubing and soldering!");
            Spec spec7 = new Spec();
            productService.saveProduct(product7,spec7);

            Product product8 = new Product("Kailh Speed Copper Gaming Switches",19.6F,"Kailh","Speed Copper","Switch","Tactile","Featuring a faster actuation speed with shorter travel distance, these switches are ideal for competitive gaming.");
            Spec spec8 = new Spec("POM","PC top, Nylon bottom","Kailh ","3-pin","Tactile","3.5mm","60g");
            productService.saveProduct(product8,spec8);

            Product product9 = new Product("Kailh Speed Silver Gaming Switches",19.6F,"Kailh ","Speed Silver","Switch","Linear","Featuring a faster actuation speed with shorter travel distance, these switches are ideal for competitive gaming.");
            Spec spec9 = new Spec("POM","PC top, Nylon bottom","Kailh ","3-pin","Linear","3.5mm","70g");
            productService.saveProduct(product9,spec9);

            Product product10 = new Product("Keychron Q8 Alice Mechanical Keyboard",185F,"Keychron","Q8 Alice","Keyboard","Kit","Keychron Q8 is a 65% Alice layout all-metal mechanical keyboard. With its all-metal CNC machined body, a full-size layout, double-gasket design, QMK/VIA support, and knob option, the Q8 meets all your practical needs and gives you a high-end typing experience.");
            Spec spec10 = new Spec("Alice","Full CNC machined aluminum","Steel","South-facing RGB LED"," (Included) Screw-in PCB stabs","Hot-swappable (5 pin & 3 pin)","Type-C");
            productService.saveProduct(product10,spec10);

            Product product11 = new Product("Durock Lupine Linear Switches",38.5F,"Durock","Lupine","Switch","Linear","Featuring 2-stage springs and a reinforced stem with decreased, this linear switch from Durock is perfect for any build.");
            Spec spec11 = new Spec("POM","Polycarbonate (PC) top, Nylon bottom","Durock (JWK)","5 pins (PCB-mount)","Linear"," 4mm total travel","62g bottom-out, dual stage (2-stage) long spring");
            productService.saveProduct(product11,spec11);

        }
    }
}
