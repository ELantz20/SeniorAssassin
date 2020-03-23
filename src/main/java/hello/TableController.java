package hello;

import org.hibernate.validator.internal.util.Contracts;

public class TableController {
    @RequestMapping(value = "/showTableWithValues", method = RequestMethod.GET)
public String showTableWithValues(Model model)
{
    //list with Persons
    ArrayList<Contact>  personsList=
            new ArrayList<Contact>();

    personsList=  this.getListOfPersons();

    model.addAttribute("list", personsList);

    return "showTableWithValues";
}
}
