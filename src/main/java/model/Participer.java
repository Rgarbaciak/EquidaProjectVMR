/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author adminsio
 */
public class Participer {
    
    private int place;
    private ArrayList<Course> lesCourses ;
    private ArrayList<Cheval> lesChevaux ;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
    
    public ArrayList<Cheval> getLesChevaux() {
    return lesChevaux;
    }

    public void setLesChevaux(ArrayList<Cheval> lesChevaux) {
        this.lesChevaux = lesChevaux;
    }
    
    public void addunCheval(Cheval pUnCheval){
        if (lesChevaux == null){
            lesChevaux = new ArrayList<Cheval>();
        }
        lesChevaux.add(pUnCheval);
    }
    
     
     
     public ArrayList<Course> getLesCourses() {
    return lesCourses;
    }

    public void setLesCourses(ArrayList<Course> lesCourses) {
        this.lesCourses = lesCourses;
    }
    
    public void addUneCourse(Course pUneCourse){
        if (lesCourses == null){
            lesCourses = new ArrayList<Course>();
        }
        lesCourses.add(pUneCourse);
    }
    
}
