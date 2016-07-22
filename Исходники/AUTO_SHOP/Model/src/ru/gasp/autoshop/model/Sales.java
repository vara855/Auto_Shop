package ru.gasp.autoshop.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Sales.findAll", query = "select o from Sales o"),
                @NamedQuery(name = "Sales.getByIdSales", query = "select o from Sales o where o.idSales = :p_idSales"),
                @NamedQuery(name = "Sales.getByIdGood", query = "select o from Sales o where o.goods1 = :p_idGood"),
                @NamedQuery(name = "Sales.getByIdFroup", query = "select o from Sales o where o.goodGroup2 = :p_idGroupGood"),
                @NamedQuery(name = "Sales.valueRubMoreThan", query = "select o from Sales o where o.valueRub > :p_valueRubMore and o.valueRub is not null"),
                @NamedQuery(name = "Sales.valueRubLessThan", query = "select o from Sales o where o.valueRub < :p_valueRubLess and o.valueRub is not null"),
                @NamedQuery(name = "Sales.valueRubExactly", query = "select o from Sales o where o.valueRub = :p_valueRubExactly and o.valueRub is not null"),
                @NamedQuery(name = "Sales.valuePercentMoreThan", query = "select o from Sales o where o.valuePercent > :p_valuePercentMore and o.valuePercent is not null"),
                @NamedQuery(name = "Sales.valuePercentLessThan", query = "select o from Sales o where o.valuePercent < :p_valuePercentLess and o.valuePercent is not null"),
                @NamedQuery(name = "Sales.valuePercentExactly", query = "select o from Sales o where o.valuePercent = :p_valuerPercentExactly and o.valuePercent is not null"),
                @NamedQuery(name = "Sales.dataEnd", query = "select o from Sales o where o.dataEnd like :p_dataEnd"),
                @NamedQuery(name = "Sales.minAmountToGetMoreThan", query = "select o from Sales o where o.minAmountToGet > :p_minAmountToGetMore"),
                @NamedQuery(name = "Sales.minAmountToGetLessThan", query = "select o from Sales o where o.minAmountToGet < :p_minAmountToGetMore"),
                @NamedQuery(name = "Sales.minAmountToGetExactly", query = "select o from Sales o where o.minAmountToGet = :p_minAmountToGetExactly"),
                @NamedQuery(name = "Sales.getByKeyWord", query = "select o from Sales o where o.keyWord = :p_keyWord"),})
public class Sales implements Serializable {
    private static final long serialVersionUID = 157246978945653193L;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_END")
    private Date dataEnd;
    @Id
    @Column(name = "ID_SALES", nullable = false)
    private BigDecimal idSales;
    @Column(name = "KEY_WORD", unique = true)
    private String keyWord;
    @Column(name = "MIN_AMOUNT_TO_GET")
    private BigDecimal minAmountToGet;
    @Column(name = "VALUE_PERCENT")
    private BigDecimal valuePercent;
    @Column(name = "VALUE_RUB")
    private BigDecimal valueRub;
    @ManyToOne
    @JoinColumn(name = "ID_GROUP")
    private GoodGroup goodGroup2;
    @ManyToOne
    @JoinColumn(name = "ID_GOOD")
    private Goods goods1;

    public Sales() {
    }

    public Sales(Date dataEnd, Goods goods1, GoodGroup goodGroup2, BigDecimal idSales, String keyWord,
                 BigDecimal minAmountToGet, BigDecimal valuePercent, BigDecimal valueRub) {
        this.dataEnd = dataEnd;
        this.goods1 = goods1;
        this.goodGroup2 = goodGroup2;
        this.idSales = idSales;
        this.keyWord = keyWord;
        this.minAmountToGet = minAmountToGet;
        this.valuePercent = valuePercent;
        this.valueRub = valueRub;
    }

    public Date getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(Date dataEnd) {
        this.dataEnd = dataEnd;
    }


    public BigDecimal getIdSales() {
        return idSales;
    }

    public void setIdSales(BigDecimal idSales) {
        this.idSales = idSales;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public BigDecimal getMinAmountToGet() {
        return minAmountToGet;
    }

    public void setMinAmountToGet(BigDecimal minAmountToGet) {
        this.minAmountToGet = minAmountToGet;
    }

    public BigDecimal getValuePercent() {
        return valuePercent;
    }

    public void setValuePercent(BigDecimal valuePercent) {
        this.valuePercent = valuePercent;
    }

    public BigDecimal getValueRub() {
        return valueRub;
    }

    public void setValueRub(BigDecimal valueRub) {
        this.valueRub = valueRub;
    }

    public GoodGroup getGoodGroup2() {
        return goodGroup2;
    }

    public void setGoodGroup2(GoodGroup goodGroup2) {
        this.goodGroup2 = goodGroup2;
    }

    public Goods getGoods1() {
        return goods1;
    }

    public void setGoods1(Goods goods1) {
        this.goods1 = goods1;
    }
}
