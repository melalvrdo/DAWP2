package libcode.webapp.controladores;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.negocio.DataService;

/**
 *
 * @author melalvrdo
 */
@Named
@ApplicationScoped
@FacesConverter(value = "alumnoConverter", managed = true)
public class alumnoConverter implements Converter<Alumno>{

    @Inject
    private DataService alumnoService;

    @Override
    public Alumno getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return alumnoService.getAlumnobyId(Integer.parseInt(value));
            }
            catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid country."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Alumno value) {
        if (value != null) {
            return String.valueOf(value.getId());
        }
        else {
            return null;
        }
    }
}
