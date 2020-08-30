package com.example.sftp.sftpservice.fileInput;

import org.elasticsearch.client.ml.EvaluateDataFrameRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class FileInput {

    public static void main(String[] args) throws IOException {

//        File file = new File("src//jilin_city_wgs84.csv");
//        //BufferedReader bufferedReader = new BufferedReader(fileInputStream);
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        String tempStr;
//        int i1 = 0;
//        ArrayList<String> arrayList = new ArrayList<>();
//        Stream<String> lines = bufferedReader.lines();
//        Stream<String> distinct = lines.distinct();
//        Optional<String> first = distinct.findFirst();
//        long count = lines.count();
//        System.out.println(count);
//        String s = bufferedReader.readLine();
//        while ((tempStr = bufferedReader.readLine()) != null) {
//            arrayList.add(tempStr);
//            i1++;
//        }
//        System.out.println(i1);
//        System.out.println(arrayList.size());
        String separator = System.lineSeparator();
        System.out.println(separator);
    }


}
