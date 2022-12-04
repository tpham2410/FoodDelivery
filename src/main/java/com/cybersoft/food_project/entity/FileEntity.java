package com.cybersoft.food_project.entity;

import javax.persistence.*;

@Entity(name = "files")
public class FileEntity {
//    create table files(
//            id int,
//            fileName varchar(50),
//    fileType varchar(50),
//    primary key(id_order,id_status),
//    foreign key(id_order) references t_order(id),
//    foreign key(id_status) references status(id)
//            );
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "fileType")
    private String fileType;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private TOderEntity tOderEntity;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusEntity statusEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public TOderEntity gettOderEntity() {
        return tOderEntity;
    }

    public void settOderEntity(TOderEntity tOderEntity) {
        this.tOderEntity = tOderEntity;
    }

    public StatusEntity getStatusEntity() {
        return statusEntity;
    }

    public void setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }
}
