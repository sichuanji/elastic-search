package com.nihao.elastic_demo.entity;


import lombok.Data;

import java.util.Date;
@Data
public class Bidding_application {

    private Integer id;

    private Integer sid;

    private Integer purid;

    private Date data;

    private String product_name;

    private Integer realy_price;

    private String prescribe;

    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPurid() {
        return purid;
    }

    public void setPurid(Integer purid) {
        this.purid = purid;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name == null ? null : product_name.trim();
    }

    public Integer getRealy_price() {
        return realy_price;
    }

    public void setRealy_price(Integer realy_price) {
        this.realy_price = realy_price;
    }

    public String getPrescribe() {
        return prescribe;
    }

    public void setPrescribe(String prescribe) {
        this.prescribe = prescribe == null ? null : prescribe.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}
