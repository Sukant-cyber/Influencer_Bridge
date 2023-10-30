import React from 'react'
import './HomeStyle.css'

const Home = () => {
  return (
    <div className="landing-page">
    <header className="header">
      <div className="header-content">
        <div className="logo">
          <h1>Influencer Bridge</h1>
          <p>Your Gateway to Success</p>
        </div>
        <button className="sign-in-button">Sign In</button>
      </div>
    </header>
    <section className="hero">
      <div className="hero-content">
        <h2>Connect with Influencers, Build your Brand</h2>
        <p>Take your social media game to the next level.</p>
        <button className="cta-button">Get Started</button>
      </div>
    </section>
  </div>
  )
}

export default Home
