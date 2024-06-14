package ar.edu.utn.frbb.tup.service;

import ar.edu.utn.frbb.tup.model.Cuenta;
import ar.edu.utn.frbb.tup.model.TipoCuenta;
import ar.edu.utn.frbb.tup.model.exception.CuentaAlreadyExistsException;
import ar.edu.utn.frbb.tup.model.exception.TipoCuentaAlreadyExistsException;
import ar.edu.utn.frbb.tup.model.exception.tipoCuentaEstaSoportada;
import ar.edu.utn.frbb.tup.persistence.CuentaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumSet;
import java.util.Set;

@Component
public class CuentaService {
    CuentaDao cuentaDao = new CuentaDao();

    @Autowired
    ClienteService clienteService;

    //Tipo  de cuentas que se van a soportar 
    private static final Set<TipoCuenta> tiposCuentaSoportados = EnumSet.of(TipoCuenta.CAJA_AHORRO, TipoCuenta.CUENTA_CORRIENTE);

    //Generar casos de test para darDeAltaCuenta
    //    1 - cuenta existente
    //    2 - cuenta no soportada
    //    3 - cliente ya tiene cuenta de ese tipo
    //    4 - cuenta creada exitosamente
    public void darDeAltaCuenta(Cuenta cuenta, long dniTitular) throws CuentaAlreadyExistsException, TipoCuentaAlreadyExistsException, tipoCuentaEstaSoportada {
        if(cuentaDao.find(cuenta.getNumeroCuenta()) != null) {
            throw new CuentaAlreadyExistsException("La cuenta " + cuenta.getNumeroCuenta() + " ya existe.");
        }
        //Chequear cuentas soportadas por el banco CA$ CC$ CAU$S
        if(!tipoCuentaEstaSoportada(cuenta)){
            throw new tipoCuentaEstaSoportada("La cuenta " + cuenta.getTipoCuenta() + " no es soportada.");
        }

        // Chequear que el cliente no tenga una cuenta de ese tipo
        if(clienteService.buscarClientePorDni(dniTitular).tieneCuenta(cuenta.getTipoCuenta(), cuenta.getMoneda())) {
            throw new TipoCuentaAlreadyExistsException("El cliente " + dniTitular + " ya tiene una cuenta de tipo " + cuenta.getTipoCuenta());
        }

        //Agregar cuenta al cliente
        clienteService.agregarCuenta(cuenta, dniTitular);
        cuentaDao.save(cuenta);
    }

    public Cuenta find(long id) {
        return cuentaDao.find(id);
    }

    private boolean tipoCuentaEstaSoportada(Cuenta cuenta){
        return tiposCuentaSoportados.contains(cuenta.getTipoCuenta());
    }
}
