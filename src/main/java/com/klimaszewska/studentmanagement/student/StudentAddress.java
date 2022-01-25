package com.klimaszewska.studentmanagement.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudentAddress {

    @Column (name="address")
    private String address;

    @Column (name="postal_code")
    private String postalCode;

    @Column (name="place")
    private String place;
}
