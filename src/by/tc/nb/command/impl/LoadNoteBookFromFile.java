package by.tc.nb.command.impl;

import by.tc.nb.bean.FileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

import java.io.IOException;
import java.text.ParseException;


public class LoadNoteBookFromFile implements Command {
    @Override
    public Response execute(Request request) throws CommandException, IOException, ParseException, ServiceException, ClassNotFoundException {
        FileRequest req = null;

        if (request instanceof FileRequest) {
            req = (FileRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        ServiceFactory service = ServiceFactory.getInstance();
        NoteBookService nbService = service.getNoteBookService();

        try {
            nbService.loadNoteBookFromFile(req.getPath());
        } catch (ServiceException e) {
            throw new CommandException();
        }
        Response response = new Response();
        response.setErrorStatus(false);
        response.setResultMessage("Operation completed!");

        return response;
    }
}
