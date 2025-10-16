import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.scss'
})
export class LandingComponent {
  constructor(private router: Router) {}

  // Features data
  features = [
    {
      icon: '📸',
      title: 'Foto & Video Sharing',
      description: 'Teile deine Erlebnisse aus Studium und Beruf mit der Community'
    },
    {
      icon: '💬',
      title: 'Diskussionen',
      description: 'Tausche dich über Themen aus, die duale Studenten bewegen'
    },
    {
      icon: '🔐',
      title: 'Interner Bereich',
      description: 'Vertraulicher Austausch in geschützter Umgebung'
    },
    {
      icon: '🤝',
      title: 'Networking',
      description: 'Baue wertvolle Kontakte für deine berufliche Zukunft auf'
    }
  ];

  // Trust indicators
  trustIndicators = [
    '🏢 Partnerhochschulen',
    '🏭 Partnerunternehmen', 
    '🎓 Studentenwerke',
    '📊 Datenschutz'
  ];

  // Statistics
  stats = {
    members: '1000+',
    discussions: '500+',
    universities: '50+'
  };

  // Methods for button actions
  onRegister(): void {
    console.log('Registrieren clicked');
    // TODO: Navigate to registration page
  }

  onLogin(): void {
    console.log('Anmelden clicked');
    // TODO: Navigate to login page
  }

  onExploreCommunity(): void {
    console.log('Community entdecken clicked');
    this.router.navigate(['/home']);
  }
}