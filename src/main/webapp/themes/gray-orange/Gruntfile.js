/* ref: http://ericnish.io/blog/compile-less-files-with-grunt */
module.exports = function(grunt) {
  grunt.initConfig({
    less: {
      development: {
        options: {                    
          optimization: 2
        },
        files: {          
          "style.css": "style.less"
        }
      }
    },
    watch: {
      styles: {
        files: ['less/**/*.less'], // which files to watch
        tasks: ['less'],
        options: {
          nospawn: true
        }
      }
    }
  });

  grunt.loadNpmTasks('grunt-contrib-less');
  grunt.loadNpmTasks('grunt-contrib-watch');

  grunt.registerTask('default', ['watch']);
};