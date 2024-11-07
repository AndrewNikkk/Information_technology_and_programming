public class Mail {
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mailAdress) throws CustomEmailFormatException {
        if (mailAdress.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$")) {
            mail = mailAdress;
            System.out.println("Почта успешно сохранена");
        } else {
            throw new CustomEmailFormatException("Неккоректный mail адрес");
        }
    }

    public static void main(String[] args) {
        Mail mail = new Mail();
        try {
           mail.setMail("kakayatopochta2055@mail.ru");
           mail.setMail("7@mail.u");
        } catch (CustomEmailFormatException e) {
            System.out.println("Произошла ошибка при вводе почты: " + e.getMessage());
            ExceptionLogger.logException(e);
        } finally {
            System.out.println(mail.getMail());
        }
    }
}
