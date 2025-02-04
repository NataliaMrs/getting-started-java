package model;


import java.util.ArrayList;

public class Model {

        private String name;

        private Integer age;

        private String isEmployed;

    public String getIsEmployed() {
        return isEmployed;
    }

    public void setIsEmployed(String isEmployed) {
        this.isEmployed = isEmployed;
    }

    private ArrayList<String> skills;

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }






}
