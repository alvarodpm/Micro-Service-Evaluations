package co.edu.uniandes.mati.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Input {
    private Long id;
    private String requestType;
    private String technology;
    private String requestdBy;
    private Integer amountOfQuestion;
    private Date date;
}
