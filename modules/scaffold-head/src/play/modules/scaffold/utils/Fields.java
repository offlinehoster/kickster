/**
 *
 * Copyright 2010, Lawrence McAlpin.
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package play.modules.scaffold.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fields {
	public static List<String> annotationNames(Field field) {
		List<String> output = new ArrayList<String>();
		Annotation[] annotations = field.getAnnotations();
		for (Annotation ann : annotations) {
			output.add(ann.annotationType().getName());
		}
		return output;
	}
	
	public static List<Class<? extends Annotation>> annotations(Field field ) {
		List<Class<? extends Annotation>> output = new ArrayList<Class<? extends Annotation>>();
		Annotation[] annotations = field.getAnnotations();
		for (Annotation ann : annotations) {
			output.add(ann.annotationType());
		}
		return output;
	}
	
	public static List<Class<? extends Annotation>> annotations(Class<?> clazz, String fieldName) {
		List<Field> fields = Classes.publicFields(clazz);
		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase(fieldName)) {
				return annotations(field);
			}
		}
		return null;
	}
	
	public static boolean isNumeric(Field field) {
		Class<?> type = field.getType();
		return Classes.isNumeric(type);
	}
}
