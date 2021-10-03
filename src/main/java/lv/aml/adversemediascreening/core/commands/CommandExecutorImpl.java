package lv.aml.adversemediascreening.core.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandExecutorImpl implements CommandExecutor {

    private final List<DomainCommandHandler> handlers;
    private Map<Class, DomainCommandHandler> commandHandlerMap;

    @Autowired
    public CommandExecutorImpl(List<DomainCommandHandler> handlers){
        this.handlers = handlers;
    }

    @PostConstruct
    public void init(){
        commandHandlerMap = new HashMap<>();
        if(handlers != null && !handlers.isEmpty()) {
            for (DomainCommandHandler handler: handlers) {
                Class domainCommandClass = handler.getCommandType();
                commandHandlerMap.put(domainCommandClass, handler);
            }
        }
    }

    @Override
    public <T extends DomainCommandResult> T execute(DomainCommand<T> command) {
        DomainCommandHandler handler = commandHandlerMap.get(command.getClass());
        if(handler != null){
            return (T) handler.execute(command);
        } else {
            throw new IllegalArgumentException("Unknown domain command! " + command.toString());
        }
    }
}
