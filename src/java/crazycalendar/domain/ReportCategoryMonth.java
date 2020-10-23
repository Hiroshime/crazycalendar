/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz
 */
public class ReportCategoryMonth  extends DomainEntity{
    
     private String content;
     private List<Month> months;
     
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    public void initMonths()
    {
        String [] names = { "Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        months = new ArrayList<>();
        Month month ;
        for (int i = 0; i < 12; i++) {
            month = new Month();
            month.setName(names[i]);
            months.add(month);
        }
    }
    
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the months
     */
    public List<Month> getMonths() {
        return months;
    }

    /**
     * @param months the months to set
     */
    public void setMonths(List<Month> months) {
        this.months = months;
    }
     
    
}
