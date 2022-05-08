document.querySelectorAll('form').forEach(form => {
  form.addEventListener('submit', (e) => {
    if (form.classList.contains('is-submitting')) {
      e.preventDefault();
      console.info('Successive submit suppressed');
    }

    form.classList.add('is-submitting');
  });
});