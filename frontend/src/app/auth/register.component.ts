import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-register',
  imports: [CommonModule, FormsModule, RouterModule],
  template: `
    <div class="auth-shell">
      <div class="card">
        <h2>Register</h2>
        <form (ngSubmit)="register()" #f="ngForm" novalidate>
          <label class="field">
            <span>Username</span>
            <input name="username" [(ngModel)]="username" #usernameModel="ngModel" required />
          </label>
          <div class="error" *ngIf="usernameModel.invalid && (usernameModel.dirty || usernameModel.touched)">
            Bitte gib einen Benutzernamen an.
          </div>

          <label class="field">
            <span>Email</span>
            <input name="email" [(ngModel)]="email" #emailModel="ngModel" required email />
          </label>
          <div class="error" *ngIf="emailModel.invalid && (emailModel.dirty || emailModel.touched)">
            Bitte gib eine gültige E‑Mail Adresse an.
          </div>

          <label class="field">
            <span>Passwort</span>
            <input type="password" name="password" [(ngModel)]="password" #passwordModel="ngModel" required minlength="4" />
          </label>
          <div class="error" *ngIf="passwordModel.invalid && (passwordModel.dirty || passwordModel.touched)">
            Bitte gib ein Passwort ein (mindestens 4 Zeichen).
          </div>

          <label class="field">
            <span>Passwort bestätigen</span>
            <input type="password" name="confirmPassword" [(ngModel)]="confirmPassword" #confirmModel="ngModel" required />
          </label>
          <div class="error" *ngIf="confirmModel.invalid && (confirmModel.dirty || confirmModel.touched)">
            Bitte bestätige dein Passwort.
          </div>

          <div class="error" *ngIf="passwordsMismatch && (confirmModel.dirty || confirmModel.touched)">
            Die Passwörter stimmen nicht überein.
          </div>

          <button class="btn" type="submit">Registrieren</button>
        </form>

        <p class="alt">Schon ein Konto? <a routerLink="/login">Login</a></p>
      </div>
    </div>
  `,
  styles: [
    `
      .auth-shell { display:flex; align-items:center; justify-content:center; height:60vh; }
      .card { width:360px; padding:20px; border-radius:6px; box-shadow:0 6px 16px rgba(0,0,0,0.06); background:#fff; }
      h2 { margin:0 0 12px 0; }
      .field { display:block; margin:8px 0; }
      .field span { display:block; font-size:13px; color:#222; margin-bottom:6px; }
      input { width:100%; padding:8px 10px; border:1px solid #ddd; border-radius:4px; }
      .btn { margin-top:12px; width:100%; padding:8px 12px; background:#1976d2; color:#fff; border:none; border-radius:4px; cursor:pointer; }
      .alt { margin-top:10px; font-size:13px; }
      .error { color:#b00020; font-size:12px; margin-top:4px; }
    `,
  ],
})
export class RegisterComponent {
  username = '';
  email = '';
  password = '';
  confirmPassword = '';

  passwordsMismatch = false;

  constructor(private router: Router) {}

  register() {
    // reset mismatch flag
    this.passwordsMismatch = false;

    // basic client-side validation
    if (!this.username || !this.email || !this.password || !this.confirmPassword) {
      // mark mismatch if passwords are empty differently
      if (this.password !== this.confirmPassword) {
        this.passwordsMismatch = true;
      }
      // let the template show required field messages (ngModel validators)
      return;
    }

    if (this.password !== this.confirmPassword) {
      this.passwordsMismatch = true;
      return;
    }

    // All good for now — in real app call AuthService
    console.log('Registering', { username: this.username, email: this.email });
    // navigate to login after successful register
    this.router.navigate(['/login']);
  }
}
