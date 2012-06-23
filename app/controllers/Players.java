package controllers;

import java.util.List;
import models.Player;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;


public class Players extends Controller {
	public static void index() {
		List<Player> entities = models.Player.all().fetch();
		render(entities);
	}

	public static void create(Player entity) {
		render(entity);
	}

	public static void show(java.lang.Long id) {
    Player entity = Player.findById(id);
		render(entity);
	}

	public static void edit(java.lang.Long id) {
    Player entity = Player.findById(id);
		render(entity);
	}

	public static void delete(java.lang.Long id) {
    Player entity = Player.findById(id);
    entity.delete();
		index();
	}
	
	public static void save(@Valid Player entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@create", entity);
		}
    entity.save();
		flash.success(Messages.get("scaffold.created", "Player"));
		index();
	}

	public static void update(@Valid Player entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@edit", entity);
		}
		
      		entity = entity.merge();
		
		entity.save();
		flash.success(Messages.get("scaffold.updated", "Player"));
		index();
	}

}
