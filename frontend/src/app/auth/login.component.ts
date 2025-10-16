import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

//cool
@Component({
  standalone: true,
  selector: 'app-login',
  imports: [CommonModule, FormsModule, RouterModule],
  template: `
    <div class="auth-shell">
      <div class="card">
        <h2>Login</h2>
        <form (ngSubmit)="login()" #f="ngForm" novalidate>
          <label class="field">
            <span>Email oder Username</span>
            <input name="identifier" [(ngModel)]="identifier" #identifierModel="ngModel" required />
          </label>
          <div class="error" *ngIf="identifierModel.invalid && (identifierModel.dirty || identifierModel.touched)">
            Bitte gib deine E‑Mail oder deinen Benutzernamen an.
          </div>

          <label class="field">
            <span>Passwort</span>
            <input type="password" name="password" [(ngModel)]="password" #passwordModel="ngModel" required />
          </label>
          <div class="error" *ngIf="passwordModel.invalid && (passwordModel.dirty || passwordModel.touched)">
            Bitte gib dein Passwort ein.
          </div>

          <div class="error" *ngIf="loginError">
            {{ loginError }}
          </div>

          <button class="btn" type="submit">Login</button>
        </form>

        <p class="alt">Noch kein Konto? <a routerLink="/register">Registrieren</a></p>
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
export class LoginComponent {
  identifier = '';
  password = '';
  loginError = '';

  constructor(private router: Router) {}

  login() {
    this.loginError = '';

    if (!this.identifier || !this.password) {
      this.loginError = 'Bitte fülle alle Felder aus.';
      return;
    }

    // simple heuristic: if contains @ treat as email
    const isEmail = this.identifier.includes('@');

    // TODO: replace with real AuthService call
    console.log('Attempt login with', { identifier: this.identifier, isEmail });

    // Fake validation for demo: accept any password of length >=4
    if (this.password.length < 4) {
      this.loginError = 'Ungültige Zugangsdaten.';
      return;
    }

    // On success navigate to home
    this.router.navigate(['/home']);
  }
}
