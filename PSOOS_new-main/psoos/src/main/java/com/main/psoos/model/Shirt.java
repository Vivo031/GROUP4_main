package com.main.psoos.model;

import com.main.psoos.dto.ShirtDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shirt")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shirt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "job_order")
    private String jobOrder;

    @Column(name = "print_type")
    private String printType;

    @Column(name = "shirt_size")
    private String shirtSize;

    @Column(name = "no_of_shirt")
    private Integer noOfShirt;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @Column(name = "price")
    private Integer price;
    @Column(name = "shirt_notes")
    private String shirtNotes;

    public Shirt(ShirtDTO shirt){
        this.shirtSize = shirt.getShirtSize();
        this.jobOrder = shirt.getJobOrder();
        this.printType = shirt.getPrintType();
        this.noOfShirt = shirt.getNoOfShirt();
        this.fileType = shirt.getFileType();
        this.shirtNotes = shirt.getShirtNotes();
    }
}
