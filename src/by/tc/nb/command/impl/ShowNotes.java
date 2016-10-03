package by.tc.nb.command.impl;


import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ShowNotesResponse;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;


public class ShowNotes implements Command {
    @Override
    public Response execute(Request request) throws CommandException, IOException, ServiceException {
        Request req = null;

        if (request instanceof Request) {
            req = request;
        } else {
            throw new CommandException("Wrong request");
        }

        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();

        try {
            nbService.showNotes();
        } catch (ServiceException e) {
            throw new CommandException();
        }

        ShowNotesResponse response = new ShowNotesResponse();
        response.setErrorStatus(false);
        response.setNotes(nbService.showNotes());
        response.setResultMessage("All OK!");


        return response;
    }
}
