import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.util.ArrayList;
import java.util.List;


public class SimpleAutoComplete {

    private final List<String> options;
    private final LineReader reader;

    public SimpleAutoComplete(List<String> options) {
        this.options = options;
        reader = createLineReader();
    }

    private LineReader createLineReader() {
        try{
            AnsiConsole.systemInstall();
            Terminal terminal = TerminalBuilder.builder().system(true).build();

            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(new StringsCompleter(options))
                    .build();

            return lineReader;
        }

        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String readInputWithAutocomplete(){
        return reader.readLine(">>");
    }
}
