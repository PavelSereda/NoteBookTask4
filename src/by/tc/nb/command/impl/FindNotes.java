package by.tc.nb.command.impl;

import by.tc.nb.bean.FindNotesRequest;
import by.tc.nb.bean.FindNotesResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class FindNotes implements Command {

    @Override
    public Response execute(Request request) throws CommandException, ServiceException {

        FindNotesRequest req = null;

        if (request instanceof FindNotesRequest) {
            req = (FindNotesRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }
        String command = req.getCommandName();
        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();


        FindNotesResponse response = new FindNotesResponse();
        response.setErrorStatus(false);
        response.setResultMessage("All OK!");

        if (command.equals("FIND_NOTES_BY_CONTENT")) {
            String note = req.getSearchingContent();
            try {
                nbService.findNotesByContent(note);
            } catch (ServiceException e) {
                throw new CommandException();
            }
            return response;
        } else {
            String date = req.getSearchingDate();
            try {
                nbService.findNotesByDate(date);
            } catch (ServiceException e) {
                throw new CommandException();
            }
            return response;
        }
    }

}
