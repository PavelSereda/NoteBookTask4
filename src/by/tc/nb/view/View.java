package by.tc.nb.view;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.controller.Controller;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class View {


    public static void main(String[] args) throws IOException, ParseException, ServiceException, ClassNotFoundException {
        Controller controller = new Controller();

        String menu = "----------------------Menu----------------------\n" +
                "|           Press 1 - Add new note              |\n" +
                "|           Press 2 - Find notes by content     |\n" +
                "|           Press 3 - Find notes by date        |\n" +
                "|           Press 4 - Show all notes            |\n" +
                "|           Press 5 - Record notes in file      |\n" +
                "|           Press 6 - Load notes from file      |\n" +
                "|           Press 0 - Exit                      |\n" +
                "------------------------------------------------|\n" +
                " Enter a command: ";

        int loop = 1;

        while (loop != 0) {
            System.out.println(menu);
            Scanner in = new Scanner(System.in);
            char reaction = in.nextLine().charAt(0);

            switch (reaction) {
                case '0': {
                    System.out.println("Programm completed successfully");
                    loop = 0;
                }
                break;
                case '1': {
                    AddNoteRequest request = new AddNoteRequest();
                    request.setCommandName("ADD_NEW_NOTE");
                    System.out.println("Your note: ");
                    request.setNote(in.nextLine());
                    Response response = controller.doRequest(request);
                    if (response.isErrorStatus() == true) {
                        System.out.println(response.getErrorMessage());
                    }
                }
                break;

                case '2': {
                    FindNotesRequest request = new FindNotesRequest();
                    request.setCommandName("FIND_NOTES_BY_CONTENT");
                    System.out.println("Searching content: ");
                    request.setSearchingContent(in.nextLine());
                    FindNotesResponse response = (FindNotesResponse) controller.doRequest(request);

                    if (response.isErrorStatus() == true) {
                        System.out.println(response.getErrorMessage());
                        System.out.println("Notes were'nt displayed");
                    } else {
                        for (Note n : response.getDetectednotes()) {
                            System.out.println(n.getDateStr() + ' ' + n.getNote());
                        }
                        System.out.println("Notes count: " + response.getDetectednotes().size());
                    }
                }
                break;

                case '3': {
                    FindNotesRequest request = new FindNotesRequest();
                    request.setCommandName("FIND_NOTES_BY_DATE");
                    System.out.println("Searching date (Format Day.Month.Year): ");
                    request.setSearchingDate(in.nextLine());
                    FindNotesResponse response = (FindNotesResponse) controller.doRequest(request);

                    if (response.isErrorStatus() == true) {
                        System.out.println(response.getErrorMessage());
                        System.out.println("Notes were'nt displayed");
                    } else {
                        for (Note n : response.getDetectednotes()) {
                            System.out.println(n.getDateStr() + ' ' + n.getNote());
                        }
                        System.out.println("Notes count: " + response.getDetectednotes().size());
                    }
                }
                break;
                case '4': {
                    Request request = new Request();
                    request.setCommandName("SHOW_NOTES");
                    ShowNotesResponse response = (ShowNotesResponse) controller.doRequest(request);

                    if (response.isErrorStatus() == true) {
                        System.out.println(response.getErrorMessage());
                        System.out.println("Notes were'nt displayed");
                    } else {
                        for (Note n : response.getNotes()) {
                            System.out.println(n.getDateStr() + ' ' + n.getNote());
                        }
                        System.out.println("Notes count: " + response.getNotes().size());
                    }
                }
                break;


                case '5': {
                    FileRequest request = new FileRequest();
                    request.setCommandName("WRITE_NOTEBOOK_IN_FILE");
                    System.out.println("Enter the path for recording");
                    request.setPath(in.nextLine());
                    Response response = controller.doRequest(request);

                    if (response.isErrorStatus() == true) {
                        System.out.println(response.getErrorMessage());
                    }
                }
                break;

                case '6': {
                    FileRequest request = new FileRequest();
                    request.setCommandName("LOAD_NOTEBOOK_FROM_FILE");
                    System.out.println("Enter the path for recording");
                    request.setPath(in.nextLine());

                    Response response = controller.doRequest(request);
                    if (response.isErrorStatus() == true) {
                        System.out.println(response.getErrorMessage());
                    }
                }
                break;
                default: {
                    System.out.println("Wrong command. Please, try again");
                }
            }
        }
    }
}
