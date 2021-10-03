package lv.aml.adversemediascreening.core.commands;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute (DomainCommand<T> command);
}
