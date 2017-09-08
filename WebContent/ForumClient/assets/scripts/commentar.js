/**
 * FOOTPRINT
 */
var group_div   =  "<div class='accordion-group'>\
                        <div class='accordion-heading green'>\
                            <a class='accordion-toggle' data-toggle='collapse'\
                            href='#$ID'>$TITLE</a>\
                        </div>\
                        <div class='accordion-body collapse' id='$ID'>\
                            $INNER\
                        </div>\
                    </div>";
var inner_div   =  "<div class='accordion-inner'>\
                        $CONTENT\
                    </div>";
/**
 * Creates a nested multi level and collapsible menu with accordion
 * @param config
 *  - An array with JSON configurations for the nested menu accordion
 *  - Example:
 *  config = [
 *              {id:'level1', title:'LEVEL 1', levels:
 *                  [ 
 *                      {id:'level1-1', title:'LEVEL 1-1', content:'text'},
 *                      {id:'level1-2', title:'LEVEL 1-2', content:'text'},
 *                      {id:'level1-2', title:'LEVEL 1-2', levels: [ ... ]}
 *                  ]
 *              },
 *              // Deepest element must contain "content" data to visualize
 *              {id:'level2', title:'LEVEL 2', content:'MY CONTENT'}, 
 *              {id:'levelN', title:'LEVEL N', content:'MY CONTENT'}
 *           ]
 */
function createAccordion(config){
    var content = '';
    config.forEach(function(level) {
        var subcontent  = group_div.replace(/\$ID/g, level.id)
                                   .replace('$TITLE', level.title);

        subcontent = subcontent.replace('$INNER', 
            inner_div.replace('$CONTENT', typeof level.levels == 'object'
                                        ? createAccordion(level.levels)
                                        : level.content));

        content = content + subcontent;
    });
    return content;
};

/**
 * Magic starts here!
 */
$(document).ready(function() {

    config = [
        {id:'level1', 
         title:'LEVEL 1',
         levels: 
        [
            {id:'level1-1', title:'LEVEL 1.1', levels:
            [
                {
                    id:'level1-1-1',
                    title:'LEVEL 1.1.1',
                    content:'Level 1.1.1 content'
                },
                {
                    id:'level1-1-2',
                    title:'LEVEL 1.1.2',
                    content:'Level 1.1.2 content'
                }
            ]},
            {id:'level1-2', title:'LEVEL 1.2', content:'Level 1.2 content'}
        ]},
        {id:'level2', title:'LEVEL 2', content:'Level 2 content'},
        {id:'level3', title:'LEVEL 3', content:'Level 3 content'}
    ];
             
    $('#tree_accordion').html(createAccordion(config));
});

