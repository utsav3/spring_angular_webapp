import { Component, Input, OnInit } from '@angular/core';
import { TodoService } from './todo.service';
import { Todo } from './todo';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'todo-list',
  templateUrl: './todo-list.component.html'
})

export class TodoListComponent implements OnInit {
  todos: Todo[];
  newTodo: Todo = new Todo();
  editing: boolean = false;
  editingTodo: Todo = new Todo();

	
  constructor(
  private todoService: TodoService,
  ){}
  	
  ngOnInit(): void {
    this.getTodos();
  }

  getTodos(): void {
	this.todoService.getTodos()
	.then(todos => this.todos = todos);
  }

  createTodo(todoForm: NgForm): void {
	    this.todoService.createTodo(this.newTodo)
      .then(createTodo => {        
        todoForm.reset();
        this.newTodo = new Todo();
        this.todos.unshift(createTodo)
      });
  }

  
  clearEditing(): void {
	    this.editingTodo = new Todo();
    this.editing = false;
  }
}