package net.ww.web.italker.push.service;

import net.ww.web.italker.push.bean.api.account.RegisterModel;
import org.hibernate.annotations.Polymorphism;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by HP on 2017/10/25.
 */
@Path("/account")
public class AccountService {


    @GET
    @Path("/test")
    public String get() {
        return "test ok";
    }

    @POST
    @Path("/register")
    // 指定请求与返回的相应体为JSON
//     @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/json")
    @Produces("application/json")
    public RegisterModel register(RegisterModel model) {
         model = new RegisterModel();
        model.setAccount("1");
        model.setPassword("2");
        model.setName("3");
        model.setPushId("4");
        return model;
    }


}
