package online.javafun.formtotable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TableCreatorController {

    @RequestMapping(path ="/tabela", produces = "text/plain")
    @ResponseBody
    String createTable(@RequestParam String headers,
                       @RequestParam String data) {
        String[] headersArray = headers.split(TableGeneratorService.DATA_SEPARATOR);
        String[] dataRows = data.split("\n");
        String[][] dataArray = new String[dataRows.length][];
        for (int i = 0; i < dataRows.length; i++) {
            dataArray[i] = dataRows[i].split(TableGeneratorService.DATA_SEPARATOR);
        }
        return TableGeneratorService.getTextTable(headersArray, dataArray);
    }
}
