package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.xlstest.XLS;

import com.fasterxml.jackson.databind.JsonNode;
import com.opencsv.CSVReader;
import io.qameta.allure.selenide.AllureSelenide;
import model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.assertj.core.api.Assertions.assertThat;


public class HomeWorkNineFileTest {

    private ClassLoader cl = HomeWorkNineFileTest.class.getClassLoader();


    @Test
    void pdfFileContainsZipTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("samplez.zip")
        )) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("pass.pdf")) {
                    PDF pdfFile = new PDF(zis);
                    assertThat(pdfFile.text).contains("WB-GI-93560283");
                }
            }
        }
    }

    @Test
    void zipFileParsingCsvTest() throws Exception {
            try (ZipInputStream zis = new ZipInputStream(
                    cl.getResourceAsStream("samplez.zip")
            )) {
                ZipEntry entry;

                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.getName().equals("sample4.csv")) {
                        CSVReader csvReader = new CSVReader(new InputStreamReader(zis)); {

                            List<String[]> data = csvReader.readAll();
                            Assertions.assertEquals(5, data.size());
                            Assertions.assertArrayEquals(
                                    new String[] {"Game Number", "Game Length"},
                                    data.get(0)
                            );
                            Assertions.assertArrayEquals(
                                    new String[] {"1", "23"},
                                    data.get(1)
                            );
                        }

                    }
                }
            }
    }


    @Test
    void zipFilXlsFileParsingTest() throws Exception {
        SelenideLogger.addListener("allure", new AllureSelenide());

        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("samplez.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("price.xlsx")) {
                    XLS xls = new XLS(zis);

                    String actualValue = xls.excel.getSheetAt(0).getRow(14).getCell(1).getStringCellValue();

                    Assertions.assertTrue(actualValue.contains("Счет на оплату № 124468 от 25 марта 2024 г. Договор № 2 174 606 от 01.03.2024"));
                }
            }
        }
    }

    @Test
    void jsonFileTest() throws Exception {
            try (Reader reader = new InputStreamReader(
                    cl.getResourceAsStream("example.json")
            )) {

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode person = objectMapper.readValue(reader, JsonNode.class);

                Assertions.assertEquals("Bob", person.get("name").asText());
                Assertions.assertEquals(30, person.get("age").asInt());
                Assertions.assertEquals("tester",person.get("isEmployed").asText());
                Assertions.assertTrue( person.get("skills").isArray());


            }
        }


    @Test
    void jsonModelFileTest() throws Exception {
        SelenideLogger.addListener("allure", new AllureSelenide());

        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("example.json")
        )) {

            ObjectMapper objectMapper = new ObjectMapper();
         Model model = objectMapper.readValue(reader, Model.class);

            Assertions.assertEquals("Bob", model.getName());
            Assertions.assertEquals(30, model.getAge());
            Assertions.assertEquals("tester",model.getIsEmployed());
            Assertions.assertEquals(List.of("JavaScript", "Python", "C++"), model.getSkills());


        }
    }





}
