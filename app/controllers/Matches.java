package controllers;

import java.util.List;
import models.Match;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;


public class Matches extends Controller {
	public static void index() {
		List<Match> entities = models.Match.all().fetch();
		render(entities);
	}

	public static void create(Match entity) {
		render(entity);
	}

	public static void show(java.lang.Long id) {
    Match entity = Match.findById(id);
		render(entity);
	}

	public static void edit(java.lang.Long id) {
    Match entity = Match.findById(id);
		render(entity);
	}

	public static void delete(java.lang.Long id) {
    Match entity = Match.findById(id);
    entity.delete();
		index();
	}
	
	public static void save(@Valid Match entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@create", entity);
		}
    entity.save();
		flash.success(Messages.get("scaffold.created", "Match"));
		index();
	}

	public static void update(@Valid Match entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@edit", entity);
		}
		
      		entity = entity.merge();
		
		entity.save();
		flash.success(Messages.get("scaffold.updated", "Match"));
		index();
	}

}
