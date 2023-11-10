package org.ochafloquet;

import com.github.javafaker.Company;
import com.github.javafaker.DragonBall;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.ochafloquet.model.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @project streamApi
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 05/10/2023
 **/
public class Main {

    private static Faker faker = new Faker();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Student> studentList = getData();

    public static void main(String[] args) {
       /* sorted(studentList, "ASC").forEach(student -> System.out.println("student.getName() = " + student.getName()));
        sorted(studentList, "DES").forEach(student -> System.out.println("student.getName() = " + student.getName()));
        System.out.println(gson.toJson(groupStudentByLocation(studentList)));
        System.out.println(gson.toJson(groupStudentByRolNumber(studentList)));*/
        //System.out.println(gson.toJson(filterByRolNumber(studentList, 2)));
        //System.out.println(gson.toJson(partitionBy()));
        //System.out.println(gson.toJson(streamToMap()));
        System.out.println(gson.toJson(getStudentMaxSalary()));

    }
    //Sorted segun tipo ascendente o desendente
    private static List<Student> sorted(List<Student> studentList, String type) {
        return (type.equalsIgnoreCase("ASC") ? studentList.stream()
                .sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList())
                : studentList.stream().sorted(Comparator.comparing(Student::getName).reversed()).collect(Collectors.toList()));
    }

    private static Map<String, List<Student>> groupStudentByLocation(List<Student> studentList) {
        return studentList.stream().collect(
                Collectors.groupingBy(Student::getLocation));
    }

    private static Map<Integer, List<Student>> groupStudentByRolNumber(List<Student> studentList) {
        return studentList.stream().collect(
                Collectors.groupingBy(Student::getRolNumber));
    }

    //Filter By Some Atributes
    private static List<Student> filterByRolNumber(List<Student> studentList, int number) {
        return studentList.stream()
                .filter(student -> student.getRolNumber() > number && student.getLocation().equalsIgnoreCase("Callao"))
                .collect(Collectors.toList());
    }
    //Particionarlistas
    private static Map<Boolean, List<Student>> partitionBy() {
        return studentList.stream().collect(
                Collectors.partitioningBy(student -> student.getFavoriteColor().equalsIgnoreCase("yellow")));
    }
    //streamToMap
    private static Map<String, Double> streamToMap(){
        return studentList.stream().distinct().collect(
                Collectors.toMap(Student::getName, Student::getSalary)
        );
    }

    private static Student getStudentMaxSalary(){
        return studentList.stream()
                .limit(15)// Aqui solo evalua los primeros 10 elementos
                .max(Comparator.comparing(Student::getSalary))
                .orElseThrow(NoSuchElementException::new);
    }


    private static List<Student> getData() {
        studentList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            studentList.add(new Student(UUID.randomUUID(),
                    faker.name().name(),
                    faker.number().randomDigitNotZero(),
                    (i < 8 ? "Lima" : "Callao"),
                    faker.color().name(),
                    faker.number().randomDouble(2,3, 4)));
        }
        return studentList;
    }


}