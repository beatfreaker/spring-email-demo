package com.beatfreaker.springemaildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine emailTemplateEngine;

    public void sendEmail(String to) throws MessagingException {
        Context context = prepareContext();
        String text = emailTemplateEngine.process("mail.html", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, null);
        mimeMessageHelper.setFrom("admin@beatfreaker.com");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Sample mail");
        mimeMessageHelper.setText(text, true);

        javaMailSender.send(mimeMessage);
    }

    private Context prepareContext() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Beatfreaker");
        data.put("employees", getEmployees());
        Context context = new Context();
        context.setVariables(data);
        return context;
    }

    private List<Employee> getEmployees() {
        Employee james = new Employee("James", "Anderson");
        Employee daisy = new Employee("Daisy", "Anderson");

        return Arrays.asList(james, daisy);
    }
}
