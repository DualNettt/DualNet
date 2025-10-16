import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {
  navItems = [
    { label: 'Home', route: '/home', icon: '🏠' },
    { label: 'Discussions', route: '/discussions', icon: '💬' },
    { label: 'Cookie', route: '/cookie', icon: '🍪' },
    { label: 'Settings', route: '/settings', icon: '⚙️' }
  ];

  activeItem: string = '';

  onNavClick(item: string) {
    this.activeItem = item;
  }

  onLogin() {
    // Placeholder for login functionality
    console.log('Login button clicked!');
    alert('Login functionality will be implemented here.');
  }
}