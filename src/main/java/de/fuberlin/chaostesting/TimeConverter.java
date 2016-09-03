package de.fuberlin.chaostesting;

import net.sourceforge.stripes.validation.DateTypeConverter;

public class TimeConverter extends DateTypeConverter {

	@Override
	protected String[] getFormatStrings() {
		return new String[]{"HH:mm"};
	}	
}
