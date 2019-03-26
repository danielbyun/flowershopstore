package com.flowershop.utility;

import com.flowershop.entity.Order;
import com.flowershop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import java.util.Locale;

@Component
public class MailConstructor {
    @Autowired
    private Environment environment;

    @Autowired
    private TemplateEngine templateEngine;

    public SimpleMailMessage constructResetTokenEmail(
            String contextPath,
            Locale locale,
            String token,
            User user,
            String password) {
        String url = contextPath + "/newUser?token=" + token;
        String message = "\nPlease click on this link to verify your email and edit your personal information! \n\nYour password is: " + password;
        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(user.getEmail());
        email.setSubject("liz's flower shop - new user registration process");
        email.setText(url + message);
        email.setFrom(environment.getProperty("support.email"));

        return email;
    }

    public MimeMessagePreparator constructOrderConfirmationEmail(User user, Order order, Locale locale) {
        // instead of using SimpleMailMessage we need to use MimeMessagePreparator to use rich text
        Context context = new Context();

        context.setVariable("order", order);
        context.setVariable("user", user);
        context.setVariable("cartItemList", order.getCartItemList());

        String text = templateEngine.process("orderConfirmationEmailTemplate", context);

        return mimeMessage -> {
            MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
            email.setTo(user.getEmail());
            email.setSubject("Your order from liz's flowershop");
            email.setText(text, true);
            email.setFrom(new InternetAddress("byunsta@gmail.com"));
        };
    }
}
