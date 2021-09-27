package taa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import taa.entity.Appointment;
import taa.repository.AppointmentRepository;

@Controller
public class AppointmentController
{

    private AppointmentRepository appointmentDao;

    @Autowired
    public void setAppointmentDao(AppointmentRepository appointmentDao){
        this.appointmentDao = appointmentDao;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create()
    {
        String appointmentId = "";
        try {
            Appointment appointment = new Appointment();
            appointmentDao.save(appointment);
            appointmentId = String.valueOf(appointment.getId());
        }catch (Exception e) {
            return "Error creating the appointment: " + e.toString();
        }
        return "Appointment succesfully created with id = " + appointmentId;
    }

    
    @RequestMapping("/delete")
    public void delete(@PathVariable String id) {
    	
    }
}
