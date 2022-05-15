package ru.geekbrains;

public class MainApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            StudentsDao studentsDaoDao = new StudentsDaoImpl(sessionFactoryUtils);

            System.out.println(studentsDaoDao.findById(1L));
            System.out.println(studentsDaoDao.findByName("Max").size());
            System.out.println();
            System.out.println(studentsDaoDao.findAll().size());
            System.out.println();
            studentsDaoDao.updateNameById(1L, "Guillermo-Noble");
            System.out.println(studentsDaoDao.findById(1L));
            System.out.println();
            studentsDaoDao.save(new Students("Guillermo-Killer", 5));
            System.out.println(studentsDaoDao.findByName("Guillermo-Killer"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
