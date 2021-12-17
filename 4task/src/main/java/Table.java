import de.vandermeer.asciitable.AsciiTable;

import java.util.ArrayList;
import java.util.List;

public class Table {
    public static void getHelp(String[] args) {
        final AsciiTable table = new AsciiTable();
        table.addRule();
        String[] columns = new String[args.length + 1];
        columns[0] = "Raw vs Column";
        System.arraycopy(args, 0, columns, 1, columns.length - 1);
        table.addRow((Object[]) columns);
        for (int i = 0; i < args.length; i++) {
            table.addRule();
            final List<String> list = new ArrayList<>(columns.length);
            list.add(args[i]);
            for (int j = 0; j < args.length; j++) {
                final int res = (args.length + i - j) % args.length;
                if (res == 0) {
                    list.add("Draw");
                } else if (res % 2 == 1) {
                    list.add("Win");
                } else {
                    list.add("Lose");
                }
            }
            table.addRow(list);
        }
        table.addRule();
        System.out.println(table.render());
    }
}
