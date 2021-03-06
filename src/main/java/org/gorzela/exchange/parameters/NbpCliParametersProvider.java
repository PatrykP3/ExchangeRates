package org.gorzela.exchange.parameters;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.Optional;

@Component
@Getter
public class NbpCliParametersProvider {

    private Optional<NbpCliParameters> optionalNbpCliParameters;

    @Autowired
    public NbpCliParametersProvider(ApplicationArguments applicationArguments) {
        NbpCliParameters ncp = new NbpCliParameters();
        try {
            CommandLine.populateCommand(ncp, applicationArguments.getSourceArgs());
            if (ncp.isHelpRequested()) {
                new CommandLine(ncp).usage(System.out);
                ncp = null;
            }
        }
        catch (CommandLine.MissingParameterException ex) {
            System.out.println("Not enough arguments. " + ex.getMessage());
            CommandLine.usage(ncp, System.out);
            ncp = null;
        }
        optionalNbpCliParameters = Optional.ofNullable(ncp);
    }
}
